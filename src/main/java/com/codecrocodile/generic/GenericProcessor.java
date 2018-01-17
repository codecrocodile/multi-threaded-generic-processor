/*
 * @(#)GenericProcessor.java			27 Jan 2014
 */
package com.codecrocodile.generic;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * @author Chris Hatton
 */
public class GenericProcessor<T, U, V, W> implements Processor<T, U> {
	
	public static final Logger log = Logger.getLogger(GenericProcessor.class.getName());
	
	private ExecutorService executorService = Executors.newCachedThreadPool();
	
	private List<Future<W>> taskFutures = new ArrayList<Future<W>>();
	
	private Splitter<T, V> splitter;
	
	private Aggregator<U, W> aggregator;

	private Class<? extends Worker<V, W>> workerCls;

	private Class<? extends W> wCls;

	
	/**
	 * Constructor
	 * 
	 * @param Splitter<T, V> splitter
	 * @param Aggregator<U, W> aggregator
	 * @param Class<? extends Worker<V, W>> workerCls 
	 * @param Class<? extends W> wCls
	 */
    public GenericProcessor(Splitter<T, V> splitter, Aggregator<U, W> aggregator, 
    		Class<? extends Worker<V, W>> workerCls, Class<? extends W> wCls) {
		this.splitter = splitter;
		this.aggregator = aggregator;
		this.workerCls = workerCls;
		this.wCls = wCls;
    }

    /*
     * @see com.codecrocodile.interfaces.Processor#process(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    public U process(T arg) {
    	log.info("Entering U process(T arg)");
    	
		V[] parts = splitter.split(arg);
    	
		Task task = null;
		for (V part : parts) {
			try {
	            task = new Task(part, workerCls.newInstance());
            } catch (InstantiationException e) {
	            e.printStackTrace();
            } catch (IllegalAccessException e) {
	            e.printStackTrace();
            }
			
			taskFutures.add(executorService.submit(task));
		}
		
		List<W> partResults = new ArrayList<W>();
		for (Future<W> taskFuture : taskFutures) {
			try {
	            partResults.add(taskFuture.get());
            } catch (InterruptedException e) {
	            e.printStackTrace();
            } catch (ExecutionException e) {
	            e.printStackTrace();
            }
		}
		
		W[] newInstance = (W[]) Array.newInstance(wCls, partResults.size());
		W[] partResultsArray = partResults.toArray(newInstance);
		
	    return aggregator.aggregate(partResultsArray);
    }    

    /*
     * Represents a unit of work that my be time consuming, but can be executed
     * in concurrently with other tasks to take advantage of multiple processor 
     * cores.
     */
	private class Task implements Callable<W> {

		private Worker<V, W> worker;
		
		private V part;

        public Task(V part, Worker<V, W> worker) {
			this.part = part;
			this.worker = worker;
        }

		/* 
		 * @see java.util.concurrent.Callable#call()
		 */
        @Override
        public W call() throws Exception {
        	log.info("Entering W call()");
        	
	        return worker.processPart(part);
        }

	}
	
}

package com.ex.threads;

import java.util.LinkedList;

public class PC
{
    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    // Function called by producer thread
    public void produce() throws InterruptedException
    {
        int value = 0;
        while (true)
        {
            synchronized (this)
            {
                // producer thread waits while list
                // is full
                while (list.size()==capacity)
                    wait();

                System.out.println("Producer produced-"
                                              + value);

                // to insert the jobs in the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // makes the working of program easier
                // to  understand
                Thread.sleep(1000);
            }
        }
    }

    // Function called by consumer thread
    public void consume() throws InterruptedException
    {
        while (true)
        {
            synchronized (this)
            {
                // consumer thread waits while list
                // is empty
                while (list.size()==0)
                    wait();

                //to retrive the ifrst job in the list
                int val = list.removeFirst();

                System.out.println("Consumer consumed-"
                                                + val);

                // Wake up producer thread
                notify();

                // and sleep
                Thread.sleep(1000);
            }
        }
    }
}

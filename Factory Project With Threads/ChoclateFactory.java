import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;

import javax.naming.event.ObjectChangeListener;

class ChoclateFactory {
    Salt salt = new Salt(100, 2);
    Cacao cacao = new Cacao(100, 2);
    Sugar sugar = new Sugar(1000, 50);
    Oil oil = new Oil(1000, 50);
    Milk milk = new Milk(100, 2);
    Queue melterMach = new LinkedList<Integer>();
    Queue mixMach = new LinkedList<Integer>();
    Queue mold = new LinkedList<Integer>();
    Queue freeze = new LinkedList<Integer>();
    Queue packer = new LinkedList<Integer>();
    Object lock = new Object();
    Object lock2=new Object();
    Object lock3=new Object();
    Object lock4=new Object();

    public void melter() throws InterruptedException {

        while (true) {

            Thread.sleep(2000);

            synchronized (lock) {
                if (oil.weight < oil.usage) {
                    break;
                }
                melterMach.add(oil.UseOil());
                System.out.println("Melting oil.");
                System.out.println(melterMach.size());
                lock.notify();

            }
        }

    }

    public void MixMach() throws InterruptedException {

        while (true) {

            Thread.sleep(500);

            synchronized (lock) {

                if (melterMach.size() <=0) {
                    lock.wait();
                }

                    if(cacao.weight<=0|| milk.weight<=0|| sugar.weight<=0)
                    {
                        Scanner scanner=new Scanner(System.in);
                        System.out.println("Malzemelerinizde eksik bulundugundan fabrika durabilir. Fabrikanin calismasinin aksamamasi icin lutfen malzeme ekleyin.");
                        int newValue=scanner.nextInt();

                        
                        cacao.Add(newValue);
                        milk.add(newValue);
                        sugar.Add(newValue);

                    }
                    
                
                    int mix = (Integer) melterMach.poll() + cacao.UseCacao() + milk.use() + sugar.UseSugar();
                    mixMach.add(mix);
                    System.out.println("Mixing oil ,milk ,sugar and cacao.");
                    System.out.println(mixMach.size());
                    lock.notify(); 
                
                


            }

            synchronized(lock2){

                if (mixMach.size() <= 0) {
                    lock2.wait();
                }
                lock2.notify();
               
            }
        }

    }

    public void Mold() throws InterruptedException{


        

        while(true){
            Thread.sleep(500);

            synchronized(lock2){
                if(mixMach.size()<=0)
                {
                    lock2.wait();
                }

                mold.add(mixMach.poll());
               
                System.out.println("Molding.");
                System.out.println(mold.size());

                lock2.notify();
            }
            synchronized(lock3){
                if(mold.size()<=0){
                    lock3.wait();
                }

                lock3.notify();
            }
        }
    }

    public void Freeze() throws InterruptedException{

        while(true){

            
        Thread.sleep(1000);

        synchronized(lock3){
            if(mold.size()<=0)
            {
                lock3.wait();
            }

            System.out.println("Freezing...");
            freeze.add(mold.poll());
            System.out.println(freeze.size());
            lock3.notify();
        }

        synchronized(lock4){
            if(freeze.size()<=0)
            {
                lock4.wait();
            }

            lock4.notify();
        }

        }

        
    }

    public void Packer() throws InterruptedException{

        while(true){

            Thread.sleep(5000);

            synchronized(lock4){
                if(freeze.size()<=0)
                {
                    lock4.wait();
                }
                System.out.println("Packing...");
                packer.add(freeze.poll());
                System.out.println(packer.size());
                lock4.notify();


            }

        }
 
    }
    
}
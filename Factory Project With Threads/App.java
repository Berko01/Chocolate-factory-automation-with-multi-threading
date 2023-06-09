public class App {
    public static void main(String[] args) throws InterruptedException {

        ChoclateFactory factory1=new ChoclateFactory();

        Thread melter1= new Thread(new Runnable() {

            @Override
            public void run() {
               try {
                factory1.melter();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
                
            }
            
        });


        Thread mixer=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    factory1.MixMach();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });

        Thread mold=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    factory1.Mold();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });

        Thread freezer=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    factory1.Freeze();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });

        Thread packager=new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    factory1.Packer();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
        });
        

        mixer.start();
        melter1.start();
        mold.start();
        
        freezer.start();
        packager.start();
        

        mixer.join();
        melter1.join();
        mold.join();
        
        freezer.join();
        packager.join();
       
    }


}

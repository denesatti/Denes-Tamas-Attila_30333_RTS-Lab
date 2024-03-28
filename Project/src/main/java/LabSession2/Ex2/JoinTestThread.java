package LabSession2.Ex2;

class JoinTestThread extends Thread{
    private int nb;
    Thread t; JoinTestThread(String n, Thread t, int nb){
        this.setName(n);
        this.t=t;
        this.nb = nb;
    }
    public void run() {
       // System.out.println("The result is:" + Main.accumlator);
        System.out.println("Thread " + this.getName() + " has entered the run() method");
        try {
            if (t != null) t.join();
            System.out.println("The result is:" + Main.accumlator);
            System.out.println("Thread " + this.getName() + " executing operation.");
            Main.accumlator += sumOfDivider();
            System.out.println("The result is:" + Main.accumlator);
            System.out.println("Thread " + this.getName() + " has terminated operation.");
        } catch(Exception e){e.printStackTrace();
        }
    }

    public long sumOfDivider(){
        long res = this.nb;
        for(int i = 1; i < this.nb/2; i++ ){
            if(this.nb % i == 0){
                res += this.nb;
            }
        }

        return res;
    }

}
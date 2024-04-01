package problem3_2;

class Thread2 extends Thread//线程2
{
    public void run()
    {
        while (RaceHorse.pb2.getValue() < 100)
        {
            RaceHorse.pb2.setValue(RaceHorse.pb2.getValue()+(int)(Math.random()*2));
            try
            {
                Thread.sleep((int)(Math.random()*50));
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

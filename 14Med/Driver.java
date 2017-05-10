public class Driver{
    public static void main(String[]args){
	RunningMedian runMed = new RunningMedian();

	runMed.add(0);
	System.out.println(runMed.getMedian()); //0
	runMed.add(2);
	System.out.println(runMed.getMedian()); //1
	runMed.add(1);
	System.out.println(runMed.getMedian()); //1
	runMed.add(3);
	System.out.println(runMed.getMedian()); //1.5 or 1
	runMed.add(1);
	System.out.println(runMed.getMedian()); //1
	runMed.add(5);
	System.out.println(runMed.getMedian()); //1.5 or 1
	runMed.add(4);
	System.out.println(runMed.getMedian()); //2
    }
}

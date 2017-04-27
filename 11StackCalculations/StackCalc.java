import java.util.*;
public class StackCalc{
    public static double eval(String exp){
	String[] ary = exp.split(" ");
	Stack<String> nums = new Stack<String>();
	for(int i = 0; i < ary.length; i ++){
	    if (isOp(ary[i])){
		String a = nums.pop();
		String b = nums.pop();
		nums.push(applyOp(b, a, ary[i]));
	    }
	    else{
		nums.push(ary[i]);
	    }
	}
	return Double.parseDouble(nums.pop());
    }

    private static boolean isOp(String str){
	return str.equals("+") ||
	    str.equals("-") ||
	    str.equals("*") ||
	    str.equals("/") ||
	    str.equals("%");
    }

    private static String applyOp(String aStr, String bStr, String op){
	double a = Double.parseDouble(aStr);
	double b = Double.parseDouble(bStr);
	if (op.equals("+")){
	    return a + b + "";
	}
	else if (op.equals("-")){
	    return a - b + "";
	}
	else if (op.equals("*")){
	    return a * b + "";
	}
	else if (op.equals("/")){
	    return a / b + "";
	}
	else{
	    return a % b + "";
	}
    }

    public static void main(String[]args){
	System.out.println(eval("10 2.0 +"));  // is 12.0
	System.out.println(eval("11 3 - 4 + 2.5 *"));   // is 30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));   // is 893.0
    }
}

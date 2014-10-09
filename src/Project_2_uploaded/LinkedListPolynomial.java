/**
 * 
 */
package Project_2_uploaded;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * Class for arithmetic operations on the expressions provided as input.
 * Addition, Subtraction, Multiplication and Exponential operations are supported.
 * 
 */
public class LinkedListPolynomial {

	/**
	 * @param args
	 */
	static String _sNegative_Error = "Negative number not supported";
	static HashMap<Integer, String> hDynamicMap = new HashMap<Integer, String>();
	static final int nBase = 100000000;
	static final int noOfDigit = (int) Math.log10(nBase);

	static String m = "4";
	static int n = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long inTime = System.currentTimeMillis();
		String addedNde = addNumber("87675673456", "5432432321");
		System.out.println("ADD OUTPUT : " + addedNde);

		String resultSub = subractNumber("87675673456", "5432432321");
		System.out.println("SUBRACT OUTPUT : " + resultSub);

		String resultMul = multiplicationHandler("87675673456", "5432432321");
		System.out.println("MULTIPLY OUTPUT : " + resultMul);

		String resultExp = ExponentialHandler("4", n);
		System.out.println("EXPONENTIAL " + resultExp);

		long pTime = System.currentTimeMillis();
		System.out.println("Time in Secs " + (pTime - inTime));

	}

	public static LinkedList<Long> frameList(String sNumber) {

		int noOfNodes;
		long sCoEff = 0;

		// To identify the no of nodes for the linked list . may have an extra
		// node for less than 4 digits
		noOfNodes = sNumber.length() / noOfDigit;

		LinkedList<Long> resList = new LinkedList<Long>();
		for (int i = 0; i < noOfNodes; i++) {
			sCoEff = Long.parseLong(sNumber.substring((sNumber.length())
					- noOfDigit, sNumber.length()));
			resList.addLast(sCoEff);
			sNumber = sNumber.substring(0, sNumber.length() - noOfDigit);
		}
		if (sNumber.length() > 0) {
			sCoEff = Long.parseLong(sNumber);
			resList.addLast(sCoEff);
		}
		return resList;
	}

	public static String addNumber(String sNum1, String sNum2) {
		LinkedList<Long> lList1 = frameList(sNum1);
		LinkedList<Long> lList2 = frameList(sNum2);
		StringBuilder sBuilder = new StringBuilder("");

		long nNum1 = 0;
		long nNum2 = 0;
		long nCarry = 0;
		int base = nBase;
		long res = 0;

		if (lList1 == null || lList2 == null)
			return null;

		while ((lList1.peek() != null) || (lList2.peek() != null)) {

			if ((lList1.peek() != null) && (lList2.peek() != null)) {
				nNum1 = lList1.pop();
				nNum2 = lList2.pop();
				// To add the result set
				res = nCarry + nNum1 + nNum2;
				// To make the carry as zero.if carry is not zero new node must
				// be inserted
				nCarry = 0;
				nCarry = res / base;
				res = res % base;
				sBuilder.insert(0, addTrailingZeros(res, nBase));// new
			} else {
				LinkedList<Long> contList;
				contList = (lList1.peek() != null) ? lList1 : lList2;

				while (contList.peek() != null) {
					res = contList.pop();
					res = res + nCarry;
					nCarry = 0;
					nCarry = res / base;
					res = res % base;
					sBuilder.insert(0, addTrailingZeros(res, nBase));// new
				}
			}
		}
		// To insert the last carry of the addition
		if (nCarry != 0) {
			sBuilder.insert(0, addTrailingZeros(nCarry, nBase));// new
		}
		return sBuilder.toString().replaceFirst("^0+(?!$)", "");
	}

	public static String subractNumber(String sNum1, String sNum2) {
		int sLen1 = sNum1.length();
		int sLen2 = sNum2.length();
		if (sLen1 < sLen2) {
			return _sNegative_Error;
		} else if (sLen1 == sLen2) {
			if ((sNum1.compareTo(sNum2)) < 0) {
				return _sNegative_Error;
			}
		}

		LinkedList<Long> res = frameList(sNum1);
		LinkedList<Long> res1 = frameList(sNum2);

		String sRes = subractHandler(res, res1);
		return sRes;
	}

	public static String subractHandler(LinkedList<Long> oList1,
			LinkedList<Long> oList2) {
		long nNum1 = 0;
		long nNum2 = 0;
		long nCarry = 0;
		long resNum = 0;
		StringBuilder sBuilder = new StringBuilder("");

		if (oList1 == null || oList2 == null)
			return null;
		while ((oList1.peek() != null) || (oList2.peek() != null)) {
			if ((oList1.peek() != null) && (oList2.peek() != null)) {
				nNum1 = oList1.pop();
				nNum2 = oList2.pop();
				nNum1 = nNum1 + nCarry;
				nCarry = 0;
				if (nNum1 < nNum2) {
					nNum1 = nNum1 + nBase;
					nCarry = -1;
				}
				resNum = nNum1 - nNum2;
				sBuilder.insert(0, addTrailingZeros(resNum, nBase));// new
			} else {

				LinkedList<Long> contList;
				contList = oList1;
				while (contList.peek() != null) {
					resNum = contList.pop();
					resNum = resNum + nCarry;
					nCarry = 0;
					sBuilder.insert(0, addTrailingZeros(resNum, nBase));// new
				}
			}
		}
		// It will be useful while we handle the negative numbers
		/*
		 * if(nCarry==-1) { Node negNode=new Node(); negNode.sCoEff=-1;
		 * negNode.exp=nExp; oResList.addLast(negNode);
		 * 
		 * }
		 */

		return sBuilder.toString().replaceFirst("^0+(?!$)", "");
	}

	public static String multiplicationHandler(String sNum1, String sNum2) {
		LinkedList<Long> oList1 = frameList(sNum1);
		LinkedList<Long> oList2 = frameList(sNum2);
		String resl = multiplyNumber(oList1, oList2);
		return resl.replaceFirst("^0+(?!$)", "");

	}

	public static String multiplyNumber(LinkedList<Long> lList1,
			LinkedList<Long> lList2) {
		int inFirstLeng = lList1.size();
		int inSecondLen = lList2.size();
		long[] nBuffer = new long[(inFirstLeng + inSecondLen)];
		long[] nCarryBuffer = new long[inFirstLeng + inSecondLen];

		long nBuffCoEff = 0;
		long nBuffCarry = 0;
		long additionCarry = 0;
		long resCoEff = 0;
		int resExp = 0;
		int nExp1 = 0;
		int nExp2 = 0;

		StringBuilder sBuilder = new StringBuilder("");
		long nResNum = 0;
		if (lList1 == null || lList2 == null)
			return null;
		for (Long sCoEff1 : lList1) {
			for (Long sCoEff2 : lList2) {
				resCoEff = sCoEff1 * sCoEff2;
				resExp = nExp1 + nExp2;
				if (resExp == 0) {
					nBuffCoEff = resCoEff % nBase;
					nBuffCarry = resCoEff / nBase;

					nBuffer[resExp] = nBuffCoEff;
					nCarryBuffer[resExp] = nBuffCarry;
				} else {
					resCoEff = resCoEff + nBuffer[resExp];
					nBuffCoEff = resCoEff % nBase;
					nBuffCarry = resCoEff / nBase;
					nBuffer[resExp] = nBuffCoEff;
					nCarryBuffer[resExp] += nBuffCarry;
				}

				nExp2++;
			}
			nExp2 = 0;
			nExp1++;
		}
		for (int i = 0; i < nBuffer.length; i++) {
			if (i == 0) {
				sBuilder.insert(0, addTrailingZeros(nBuffer[i], nBase));
			} else {
				nResNum = nBuffer[i] + nCarryBuffer[i - 1];
				additionCarry = nResNum / nBase;
				nResNum = nResNum % nBase;
				nCarryBuffer[i] += additionCarry;
				sBuilder.insert(0, addTrailingZeros(nResNum, nBase));
			}
		}
		return sBuilder.toString();
	}

	public static String addTrailingZeros(long nNum, int nBase) {
		int noOfDigit = (int) Math.log10(nBase);
		String formatted = "%0" + noOfDigit + "d";
		String resData = String.format(formatted, nNum);

		return resData;

	}

	public static String ExponentialHandler(String m, int n) {
		hDynamicMap=new HashMap<Integer, String>();
		hDynamicMap.put(1, m);
		String res = mPowerN(m, n);
		return res;
	}

	public static String mPowerN(String m, int n) {
		String mapEntry;

		if ((mapEntry = hDynamicMap.get(n)) != null) {
			return mapEntry;
		}
		if (n == 0)
			return m;

		if ((n & 1) == 0) {
			hDynamicMap
					.put(n,
							multiplicationHandler(mPowerN(m, n / 2),
									mPowerN(m, n / 2)));
		} else {
			hDynamicMap.put(
					n,
					multiplicationHandler(
							m,
							multiplicationHandler(mPowerN(m, n / 2),
									mPowerN(m, n / 2))));

		}
		return hDynamicMap.get(n);

	}
}

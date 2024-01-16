/**
 * Class with methods to implement the basic arithmetic operations by
 * operating on bit fields.
 *
 * This is the skeleton code form COMP2691 Assignment #2.
 */
public class BinaryCalculator{
	
    public static BitField add(BitField a, BitField b){
    	if(null == a || null == b || a.size() != b.size()){
    		throw new IllegalArgumentException("BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");
    	}
    	BitField addition = new BitField(a.size());
    	boolean carryBit = false; 
    	boolean carryBitOut = false; 
    	
    	for(int i = 0; i < a.size(); i++) { 
    		//case for if both values are 1
    		if (a.get(i) && b.get(i)) {
    			addition.set(i, false);
    			carryBitOut = true; 
    			
    			if(carryBit) {
    				addition.set(i, true);
    			}
    		}
    		//case for if one value is 0 and one value is 1
    		else if (a.get(i)|| b.get(i)) {
    			addition.set(i, true);
    			
    			if(carryBit) {
    				addition.set(i, false);
    				carryBitOut = true; 
    			}
    		}
    		//case for if both values are 0 
    		else if (!a.get(i) && !b.get(i)) {
    			addition.set(i, false);
    			
    			if(carryBit) {
    				addition.set(i, true);
    			}
    		}
    		carryBit = carryBitOut; 
    		carryBitOut = false; 
    	}
	return addition; 
    }

    public static BitField subtract(BitField a, BitField b){
    	if(null == a || null == b || a.size() != b.size()){
    		throw new IllegalArgumentException("BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");
	}
    	BitField tmp = flipSign(b); 
    	return add (a,tmp);
    }

    public static BitField multiply(BitField a, BitField b){
    	if(null == a || null == b || a.size() != b.size()){
    		throw new IllegalArgumentException("BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");
    	}
    	BitField product = new BitField(a.size());
    	for(int i = 0; i < a.size(); i++) {
    		if(b.getLSB()) {
    			product = add(a, product);
    		}
    		//shifting the multiplicand left 
    		a = shiftLeftOne(a);
    		//shifting the multiplier right 
    		b = shiftRightOne(b);  
    	}
    	return product;
    }

    public static BitField[] divide(BitField a, BitField b){
    	if(null == a || null == b || a.size() != b.size()){
    		throw new IllegalArgumentException("BinaryCalculator.add(a,b): a and b cannot be null and must be the same length.");
    	}
    	BitField aCopy = new BitField(a.size() ); 
    	BitField bCopy = new BitField(b.size() );
    	BitField remainder = new BitField(a.size() * 2); 
    	BitField quotient = new BitField(a.size() * 2);
    	BitField divisor = new BitField(b.size() * 2); 
    	
    	//store if MSB is negative 
    	boolean aMostSig = false; 
    	boolean bMostSig = false; 
    	
    	//checks if divisor is 0
    	if(checkZero(b)) {
    		return null; 
    	}
    	
    	//take absolute value of a & b  
    	if(a.getMSB()) {
    		aCopy = flipSign(a);
    		aMostSig = true; 
    	}  
    	else { 
    		aCopy = a.copy(); 
    	} 
    	if(b.getMSB()) {
    		bCopy = flipSign(b); 
    		bMostSig = true; 
    	}
    	else {
    		bCopy = b.copy(); 
    	} 
    	
    	//division 
    	for(int i = 0; i < a.size() ; i++){
    		divisor = shiftLeftOne(divisor); 
    	}
    	
    	for(int i = 0; i <= a.size()  ; i++) {
    		remainder = subtract(remainder, divisor); 
    		
    		//if MSB in remainder is 0 
    		if(!remainder.getMSB()) {
    			quotient = shiftLeftOne(quotient); 
    		}
    		else if(remainder.getMSB()){
    			remainder = add(remainder, divisor); 
    			quotient = shiftLeftOne(quotient); 
    		}
    		shiftRightOne(divisor); 
    	}
    	
    	quotient = halfSize(quotient); 
    	remainder = halfSize(remainder); 
    	
    	//fix quotient & remainder signs 
    	if(aMostSig && bMostSig) {
    		remainder = flipSign(remainder); 
    	}
    	else if (bMostSig) {
    		divisor = flipSign(quotient); 
    	}
    	
    	// Return both the quotient and the remainder
    	BitField[] out = new BitField [ 2 ];
    	out[0] = quotient;  // quotient
    	out[1] = remainder; // remainder
    	return out; 
    }	
    //shifting bits to the right function 
    public static BitField shiftRightOne (BitField a) {
    	BitField out = new BitField (a.size());
    	for (int i = 1; i < a.size(); i++) {
    		out.set(i-1,a.get(i));
    	}
    	return out; 
    }
    //shifting bits to the left function 
    public static BitField shiftLeftOne (BitField a) {
    	BitField out = new BitField (a.size()); 
    	for (int i = 0; i < a.size()-1; i++) {
    		out.set(i+1, a.get(i));
    	}
    	return out; 
    }
    //flip the sign function 
    public static BitField flipSign(BitField a) {
    	//take the complement of a 
    	BitField tmp = complement(a);
    	// add 1 
    	BitField one = new BitField(a.size());
    	one.set(0, true);
    	return add (tmp, one); 
    } 
    //complement function
    public static BitField complement(BitField a) {
    	BitField out = new BitField(a.size());
    	for(int i = 0; i < a.size(); i++) {
    		//flips the sign at the specified index
    		out.set(i, !a.get(i));  
    	}
    	return out; 
    }
    //used for divide, checking if divisor is zero 
    public static boolean checkZero(BitField a) {
    	for(int i = 0; i < a.size(); i++) {
    		if(a.get(i)) {
    			return false; 
    		}
    	}
    	return true;
    }
    
    //half the size of the BitField
    public static BitField halfSize (BitField a) {
    	BitField copy = new BitField(a.size()/2); 
    	for(int i = 0; i < a.size()-1; i++) {
    		copy = a.copy(); 
    	}
    	return copy; 
    }
}
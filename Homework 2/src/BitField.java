import java.util.Arrays;

public class BitField
{
    private final boolean[] m_bits;

    public BitField(int size)
    {
	if(size <= 0){
	    throw new IllegalArgumentException(String.format("BitField.BitField(%d) is not allowed.", size));
	}
	m_bits = new boolean [ size ];
    }

    public BitField(String value)
    {
	this((null == value ? 0 : value.length()), value);
    }

    public BitField(int size, String value)
    {
	if(size <= 0){
	    throw new IllegalArgumentException(String.format("BitField.BitField(%d) is not allowed.", size));
	}
	if(null == value){
	    throw new IllegalArgumentException("BitField.BitField(int,(String)null) is not allowed.");
	}
	if(value.length() > size){
	    throw new IllegalArgumentException(String.format("BitField.BitField(%d,\"%s\") not allowed.", size, value));
	}
	m_bits = new boolean [ size ];
	// change the order
	for(int i=value.length()-1, idx = 0; i >= 0; i--, idx++){
	    m_bits[idx] = !(value.charAt(i) == '0');
	}

    }

    public BitField(byte[] data)
    {
	this((null == data ? 0 : data.length*Constants.BITS_PER_BYTE), data);
    }
    
    public BitField(int size, byte[] data)
    {
	if(0 == size){
	    throw new IllegalArgumentException("BitField.BitField(0, (byte[])) is not allowed.");
	}
	if(null == data){
	    throw new IllegalArgumentException("BitField.BitField(int,(byte[])null) is not allowed.");
	}
	if(data.length == 0){
	    throw new IllegalArgumentException("BitField.BitField(int,(byte[]){}) is not allowed.");
	}
	if(data.length*Constants.BITS_PER_BYTE > size){
	    throw new IllegalArgumentException(String.format("BitField.BitField(int,(byte[]) data length (%d) is too big for specified bits (%d)", (data.length*Constants.BITS_PER_BYTE), size));
	}
	m_bits = new boolean [ size ];
	int idx = 0;
	for(int i=(data.length-1); i>=0; i--){
	    int bits = data[i];
	    int mask = 0x1;
	    for(int j=0; j<Constants.BITS_PER_BYTE; j++){
		m_bits[idx++] = (bits & mask) != 0;
		mask <<= 1;
	    }
	}
    }

    public BitField copy()
    {
	BitField out = new BitField(m_bits.length);
	for(int i=0; i<m_bits.length; i++){
	    out.m_bits[i] = m_bits[i];
	}
	return out;
    }

    public boolean equals(Object other)
    {
	// checks type consistency and not-null:
	if(!(other instanceof BitField)){
	    return false;
	}
	BitField that = (BitField)other;
	return Arrays.equals(m_bits, that.m_bits);
    }

    public boolean get(int index)
    {
	return m_bits[index];
    }

    public boolean getLSB()
    {
	return m_bits[0];
    }

    public boolean getMSB()
    {
	return m_bits[m_bits.length-1];
    }

    public void set(int index, boolean value)
    {
	m_bits[index] = value;
    }

    public void setAll(boolean value)
    {
	for(int i=0; i<m_bits.length; i++){
	    m_bits[i] = value;
	}
    }

    public void setAllTrue()
    {
	setAll(true);
    }

    public void setAllFalse()
    {
	setAll(false);
    }

    public void setFalse(int index)
    {
	m_bits[index] = false;
    }

    public void setTrue(int index)
    {
	m_bits[index] = true;
    }

    public int size()
    {
	return m_bits.length;
    }

    public String toString()
    {
	StringBuilder sb = new StringBuilder();
	for(boolean b : m_bits){
	    // put the character at the beginning
	    sb.insert(0, (b ? '1' : '0'));
	}
	return sb.toString();
    }

    public long toLongSigned()
    {
	if(m_bits.length > Long.SIZE){
	    throw new RuntimeException(String.format("BitField.toLongSigned() called on a %d-bit field.", m_bits.length));
	}
	long out = 0;
	long value = 1;
	for(int i=0; i<(m_bits.length-1); i++){
	    if(m_bits[i]){
		out += value;
	    }
	    value += value;
	}
	if(m_bits[m_bits.length-1]){
	    out -= value;
	}
	return out;
    }

    public int toIntSigned()
    {
	if(m_bits.length > Integer.SIZE){
	    throw new RuntimeException(String.format("BitField.toIntSigned() called on a %d-bit field.", m_bits.length));
	}
	int out = 0;
	int value = 1;
	for(int i=0; i<(m_bits.length-1); i++){
	    if(m_bits[i]){
		out += value;
	    }
	    value += value;
	}
	if(m_bits[m_bits.length-1]){
	    out -= value;
	}
	return out;
    }
}
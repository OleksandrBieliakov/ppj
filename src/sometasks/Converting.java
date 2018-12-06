package sometasks;

public class Converting {
	public static void main(String[] args) {
		byte varByte = 127;
        varByte = 0b1111111;
        varByte = 0x7F;
        varByte = 0177;

		varByte = -128;
		varByte = -0b10000000;
		varByte = -0x80;
		varByte = -0200;

		short varShort = 32767;
		varShort = 0b111111111111111;
		varShort = 0x7FFF;
		varShort = 077777;

		varShort = -32768;
		varShort = -0b1000000000000000;
		varShort = -0x8000;
		varShort = -0100000;

		char varChar = 65535;
		varChar = 0b1_111_111_111_111_111;
		varChar = 0xFFFF;
		varChar = 0177777;

		int varInt = 2147483647;
		varInt = 0b1111111111111111111111111111111;
		varInt = 0x7FFFFFFF;
		varInt = 017777777777;

		varInt = -2147483648;
		varInt = -0b10000000000000000000000000000000;
		varInt = -0x80000000;
		varInt = -020000000000;
	}
}
package mIcrosoft;

public class ExcelNumberToTitle {
	
	public int titleToNumber(String columnTitle) {
        int colNumber = 0;
        int idx = 0;
        for(int i = columnTitle.length() - 1;i >= 0;i--) {
            int num = columnTitle.charAt(i) - 'A';
            num++;
            colNumber += (Math.pow(26, idx) * num);
            idx++;
        }
     
        return colNumber;
    }

}

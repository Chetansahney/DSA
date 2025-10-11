class Solution {
    public String intToRoman(int num) 
    {
      int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<values.length;i++)
        {
            int count=num/values[i];
            num=num%values[i];
            while(count>0)
            {
                sb.append(symbols[i]);
                count--;
            }
            if(num==0)
            break;
        }
        return sb.toString();
    }
    }
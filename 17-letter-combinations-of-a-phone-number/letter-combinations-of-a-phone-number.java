class Solution {
    public List<String> letterCombinations(String digits) 
    { 


        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");map.put('8',"tuv");map.put('9',"wxyz");
        List <String> result=new ArrayList<>();
        if (digits.length() == 0) return result;
        int idx= 0;String wrd="";
        solve(result,map,idx,digits,wrd);
        return result;
    }
       private void solve(List<String> result, HashMap<Character, String> map,int idx,String digits,String wrd)
        {
            if(idx>=digits.length())
            {
                result.add(wrd);
                return;
            }
            else
            {
                String str = map.get(digits.charAt(idx));
                for(int i=0;i<str.length();i++)
                {
                    solve(result,map,idx+1,digits,wrd+str.charAt(i));
                    
                }
            }
        }
        
    }

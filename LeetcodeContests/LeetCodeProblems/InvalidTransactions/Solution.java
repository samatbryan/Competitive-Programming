/*
Medium

A transaction is possibly invalid if:

the amount exceeds $1000, or;
if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
Each transaction string transactions[i] consists of comma separated values
representing the name, time (in minutes), amount, and city of the transaction.

Given a list of transactions, return a list of transactions that are possibly invalid.  You may return the answer in any order.

*/

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Set<String> unique = new HashSet<String>();
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<t>> hm = new HashMap<String, ArrayList<t>>();

        for(int i=0; i<transactions.length; i++){
            String[] parse = transactions[i].split(",");
            String name = parse[0];
            if(Integer.parseInt(parse[2])>1000){
                if(!unique.contains(transactions[i])){
                    res.add(transactions[i]);
                    unique.add(transactions[i]);

                }
            }
            t tee = new t(Integer.parseInt(parse[1]),Integer.parseInt(parse[2]),parse[3],transactions[i]);

            if(hm.containsKey(name)){
                for(int j=0; j<hm.get(name).size(); j++){
                    t next = hm.get(name).get(j);
                    if(Math.abs(next.time - Integer.parseInt(parse[1]))<=60 && !next.city.equals(parse[3])){
                        if(!unique.contains(transactions[i])){
                            unique.add(transactions[i]);
                            res.add(transactions[i]);
                        }
                        if(!unique.contains(next.og)){
                            unique.add(next.og);
                            res.add(next.og);

                        }
                    }

                }
                hm.get(name).add(tee);
            }
            else{
                ArrayList<t> a = new ArrayList<t>();
                a.add(tee);
                hm.put(name,a);
            }

        }

        return res;
    }

    static class t{
        String city;
        int time;
        int price;
        String og;

        t(int time, int price, String city, String og){
            this.city = city;
            this.time = time;
            this.price = price;
            this.og = og;
        }
    }
}

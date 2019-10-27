package Interpreter;

import Constant.Const;

public class Parser {
    public static Expression parse(String exp) throws ParseException {
        String[] nodes = exp.split(" ");
//        for(String string:nodes){
//            System.out.println(string);
//        }
        return parse(nodes, 0, nodes.length);
    }

    private static Expression parse(String[] nodes, int start, int end) throws ParseException {
        if(start == end){
            return null;
        }else if(start == end - 1){
            return new NumberExpression(nodes[start]);
        }

        assert end - start >= 3;

        //Add
        for(int i = start+1; i < end; i++){
            int op = isOp(nodes[i]);
            if(op == 1){
                return new AddExpression(parse(nodes,start,i),
                        parse(nodes,i+1,end));
            }
        }
        //Multiply
        for(int i = start+1; i < end; i++){
            int op = isOp(nodes[i]);
            if(op == 2){
                return new MultiplyExpression(parse(nodes,start,i),
                        parse(nodes,i+1,end));
            }
        }
        throw new ParseException("Invalid Expression");
    }

    /**
     * @param str 用户输入字符串的分割单元
     * @return 是否是操作符
     */
    static int isOp(String str){
        switch (str.charAt(0)){
            case '+':
                return 1;
            case '*' :
                return 2;
            default:
                return 0;
        }
    }

    public static void main(){
        try {
            double ret = Parser.parse("1 + 2 * 3"+" + "+ Const.VALUE_CROP).interpret();
            System.out.println(ret);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

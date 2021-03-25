package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 实现栈
 * @date 2021-03-17 10:33
 */
public class JikeStack {
    private String[] stack;
    private Integer count;
    private Integer n;

    public Integer getCount() {
        return count;
    }

    public JikeStack(Integer n) {
        this.n = n;
        stack = new String[n];
        count = 0;
    }

    public void push(String val){
        if (count.equals(n)){
            System.out.println("栈已经满了，无法添加元素");
        }else {
            stack[count++] = val;
        }
    }

    public String pop(){
        if (count == 0){
            System.out.println("栈为空");
        }else{
            String temp = stack[count-1];
            count--;
            return temp;
        }
        return " ";
    }

    public void show(){
        Arrays.stream(stack).forEach(System.out::println);
    }

    /**
     * @Author 林北
     * @Description //TODO 括号匹配
     * @Param [params] 括号表达式
     * @return java.lang.Integer
     **/
    public void brackets(String params){
        JikeStack jikeStack = new JikeStack(params.length());
        boolean flag = true;
        for (int i = 0;i < params.length();i++){
            switch (params.charAt(i)) {
                case '{':
                case '(':
                case '[':
                case '<':
                    jikeStack.push(String.valueOf(params.charAt(i)));
                    break;
                case '}':
                    if (!jikeStack.pop().equals(String.valueOf('{'))){
                        flag = false;
                    }
                    break;
                case ')':
                    if (!jikeStack.pop().equals(String.valueOf('('))){
                        flag = false;
                    }
                    break;
                case ']':
                    if (!jikeStack.pop().equals(String.valueOf('['))){
                        flag = false;
                    }
                    break;
                case '>':
                    if (!jikeStack.pop().equals(String.valueOf('<'))){
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("非法字符");
                    break;
            }
        }
        if (flag){
            System.out.println("匹配成功");
        }else{
            System.out.println("匹配失败");
        }
    }


    public static void main(String[] args) {
        JikeStack jikeStack = new JikeStack(4);
        jikeStack.brackets("[(<{[]}>)]");
        for (int i = 0; i<4 ;i++){
            jikeStack.push(String.valueOf(i));
        }
        jikeStack.show();
        System.out.println(jikeStack.pop());
        System.out.println(jikeStack.pop());
        System.out.println(jikeStack.pop());
        System.out.println(jikeStack.pop());
        System.out.println(jikeStack.pop());

    }
}

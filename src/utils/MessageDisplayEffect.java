package utils;

public class MessageDisplayEffect {
    private static int flag1 = 5;
    private static int flag2 = 0;//0表示向右，1表示向左
    private static int flag3 = 0;

    /**
     *  将此方法放在循环里面，将返回一个从5到10，从10到5不断摇摆的数字。
     */
    public static int sway(){
        if(flag3 == 3){
            if(flag2 == 0){
                flag1++;
                if(flag1 == 10){
                    flag2 =1;
                }
            }else if(flag2 == 1){
                flag1--;
                if(flag1 == 5){
                    flag2 = 0;
                }
            }
        }
        flag3 = ++flag3 % 4;
        return flag1;
    }

//    public static void main(String[] args) {
//        while (true){
//            System.out.println(sway());
//        }
//    }

}

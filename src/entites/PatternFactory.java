package entites;

import utils.Constant;

import java.awt.*;
import java.util.Random;

public class PatternFactory {
    private static int[][][] blockPattern1 ={
            {
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,1,0},
                    {1,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0}
            },
            {
                    {0,0,1,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    private static int[][][] blockPattern2 ={
            {
                    {0,1,0,0},
                    {0,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,1,0},
                    {0,0,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    private static int[][][] blockPattern3 ={
            {
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {1,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,1,0},
                    {0,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0}
            }
    };

    private static int[][][] blockPattern4 ={
            {
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    private static int[][][] blockPattern5 ={
            {
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0}
            },
            {
                    {1,1,1,1},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,1,1},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0},
                    {1,0,0,0}
            }
    };

    private static int[][][] blockPattern6 ={
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,1,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,0,0,0},
                    {1,1,0,0},
                    {0,1,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,1,0},
                    {1,1,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    private static int[][][] blockPattern7 ={
            {
                    {0,1,0,0},
                    {1,1,0,0},
                    {1,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {0,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            },
            {
                    {0,1,0,0},
                    {1,1,0,0},
                    {1,0,0,0},
                    {0,0,0,0}
            },
            {
                    {1,1,0,0},
                    {0,1,1,0},
                    {0,0,0,0},
                    {0,0,0,0}
            }
    };

    private static Random random = new Random();

    public static Pattern creatBlockPattern(){
        int[][][] blockPattern = null;
        int randomGamePattern = random.nextInt(7) + 1;
        int direction = random.nextInt(4);
        switch(randomGamePattern){
            case 1 :
                blockPattern = blockPattern1;
                break;
            case 2 :
                blockPattern = blockPattern2;
                break;
            case 3 :
                blockPattern = blockPattern3;
                break;
            case 4 :
                blockPattern = blockPattern4;
                break;
            case 5 :
                blockPattern = blockPattern5;
                break;
            case 6 :
                blockPattern = blockPattern6;
                break;
            case 7 :
                blockPattern = blockPattern7;
                break;
        }
        Color color = Constant.getRandomColor();
        return new Pattern(blockPattern, direction, color);
    }

}

import java.io.*;
import java.util.Scanner;
public class Test
{
    static int[][] map;

    public static void main(String[] args)
    {
        test();

        int i = 0;
    }

    public static void test()
    {
        try
        {
            Scanner inFile = new Scanner(new File("level1.txt")); 

            int count = 0;
            int row = 0;

            int tileSize = 60;
            int mapHeight = 12; //?
            int mapLength = 0;
            int cherryNum = 0;

            while(inFile.hasNext())
            {
                if(count == 0)
                {
                    mapLength = inFile.nextInt();
                    map = new int[mapHeight][mapLength];
                }

                else if(count == 1)
                {
                    cherryNum = inFile.nextInt();
                }

                else
                {
                    String line = inFile.nextLine();

                    if(!line.equals(""))
                    {
                        String[] tokens = line.split(" ");

                        for(int i = 0; i < tokens.length; i++)
                        {
                            map[row][i] = Integer.parseInt(tokens[i]);
                        }

                        row++;
                    }
                }

                count++;
            }
            inFile.close();

            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

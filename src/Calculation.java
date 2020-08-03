public class Calculation {
    static StringBuilder cstring = new StringBuilder();
    static boolean PlusSign = true;
    static int CloseBracket,OpenBracket;
    static int FinishPos = 0, StartPos = 0;

    public static int valueCalc(String input)
    {
        int Slots = 0;
        for (int i = 0; i < input.length(); i++)
        {
            if ((input.charAt(i) == '+') || (input.charAt(i) == '-') ||
                    (input.charAt(i) == '*') || (input.charAt(i) == '/')||
                    (input.charAt(i) == ')')|| (input.charAt(i) == '('))
            {
                Slots++;
            }
        }
        return Slots;
    }
    public static void calculate(String input)
    {
        int[] CharsPos = new int[valueCalc(input)+2];
        float a = 0, b = 0;
        Float c = null;
        cstring.delete(0, cstring.length());
        cstring.append(input);
        for (int i = 0; i < cstring.length(); i++)
        {
            if(cstring.charAt(i)=='(')
            {
                OpenBracket=i;
            }
            if(cstring.charAt(i)==')')
            {
                CloseBracket=i;
                String subString=new String();
                subString=cstring.substring(OpenBracket+1, CloseBracket);
                cstring.delete(OpenBracket, CloseBracket+1);
                StringBuilder mainString=new StringBuilder(cstring);
                calculate(subString);
                mainString.insert(OpenBracket,cstring.toString());
                cstring.delete(0, cstring.length());
                cstring.insert(0, mainString.toString());
                calculate(cstring.toString());
            }
        }
        for (int i = 0; i < cstring.length(); i++)
        {
            if (cstring.charAt(i) == '*')
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }

                a = Float.parseFloat(cstring.substring(StartPos, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(StartPos, FinishPos);
                c = a * b;
                cstring.insert(StartPos, c.toString());
                calculate(cstring.toString());
                break;
            }
            if (cstring.charAt(i) == '/')
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }

                a = Float.parseFloat(cstring.substring(StartPos, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(StartPos, FinishPos);
                c = a / b;
                cstring.insert(StartPos, c.toString());
                calculate(cstring.toString());
                break;
            }

        }
        for (int i = 0; i < cstring.length(); i++)
        {
            if ((cstring.charAt(i) == '*') || (cstring.charAt(i) == '/'))
            {
                calculate(cstring.toString());
            }
        }
        for (int i = 0; i < cstring.length(); i++)
        {
            if ((cstring.charAt(i) == '+') && (PlusSign == true))
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }
                a = Float.parseFloat(cstring.substring(StartPos, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(StartPos, FinishPos);
                c = a + b;
                cstring.insert(StartPos, c.toString());
                break;
            }
            if ((cstring.charAt(i) == '+') && (PlusSign == false))
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }
                a = Float.parseFloat(cstring.substring(0, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(0, FinishPos);
                if (b > a)
                {
                    c = b - a;
                    PlusSign = true;
                }
                else
                {
                    c = a - b;
                }
                cstring.insert(0, c.toString());
                break;
            }
            if ((cstring.charAt(i) == '-') && (PlusSign == true))
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }
                a = Float.parseFloat(cstring.substring(0, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(0, FinishPos);
                if (b > a)
                {
                    c = b - a;
                    PlusSign = false;
                }
                else
                {
                    c = a - b;
                }
                cstring.insert(0, c.toString());
                break;
            }
            if ((cstring.charAt(i) == '-') && (PlusSign == false))
            {
                CharsPos[0]=0;
                for (int j = 0,  k = 1; j < cstring.length()-1; j++)
                {
                    if ((cstring.charAt(j) == '+') || (cstring.charAt(j) == '-') ||
                            (cstring.charAt(j) == '*') || (cstring.charAt(j) == '/')||
                            (cstring.charAt(j) == '(')|| (cstring.charAt(j) == ')'))
                    {
                        CharsPos[k] = j+1;
                        k++;
                    }
                    CharsPos[CharsPos.length-1]=cstring.length()+1;
                }
                for(int k=0;k<CharsPos.length;k++)
                {

                    if(CharsPos[k]==i+1)
                    {
                        StartPos=CharsPos[k-1];
                        FinishPos=CharsPos[k+1]-1;
                    }
                }
                a = Float.parseFloat(cstring.substring(0, i));
                b = Float.parseFloat(cstring.substring(i + 1, FinishPos));
                cstring.delete(0, FinishPos);
                c = a + b;
                cstring.insert(0, c.toString());
                break;
            }
        }
        for (int i = 0; i < cstring.length(); i++)
        {
            if ((cstring.charAt(i) == '+') || (cstring.charAt(i) == '-'))
            {
                calculate(cstring.toString());
            }
        }
    }
}

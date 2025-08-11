using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SD_Project11
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("press 1 or 2 or 3 : ");

            int key = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine(key);
            if (key == 1)
            {
                Console.WriteLine("enter a number ");
                int num1 = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine(Convert.ToString(Fibu(num1)));
            }
            else if (key == 2)
            {
                Console.WriteLine("avalin jomle donbaale : ");
                int a0 = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("ghadr nesbat donbaale : ");
                int dq = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("adade (n)om donbaale : ");
                int n = Convert.ToInt32(Console.ReadLine());

                Console.WriteLine("jomle (n) donbaale Hesaabi : ");
                Console.WriteLine(Convert.ToString(Hesaabi(a0, dq, n)));
                Console.WriteLine("jomle (n) donbaale Hendesi : ");
                Console.WriteLine(Convert.ToString(Hendesi(a0, dq, n)));
            }
            else if (key == 3)
            {
                Console.WriteLine("matrix chand bodi baashe ? ");
                int n = Convert.ToInt32(Console.ReadLine());
                Matrix(n);
            }
            else
            {
                Console.WriteLine("adad beyne 1 ta 3 nist !");
            }
            Console.ReadKey();
        }
        //------------------------------------------------ Fibu
        static int Fibu(int num1)
        {
            if ((num1 == 0) || (num1 == 1))
            {
                return num1;
            }
            else
            {
                return (Fibu(num1 - 1) + Fibu(num1 - 2));
            }
        }
        //-------------------------------------------------- Donbaale
        static int Hesaabi(int a0, int dq, int n)
        {
            if (n == 1)
            {
                return a0;
            }
            else
            {
                return Hesaabi(a0, dq, n - 1) + dq;
            }
        }
        static int Hendesi(int a0, int dq, int n)
        {
            if (n == 1)
            {
                return a0;
            }
            else
            {
                return Hendesi(a0, dq, n - 1) * dq;
            }
        }
        //-------------------------------------------------- Matrix
        static void Matrix(int n)
        {
            double[,] m1 = new double[n, n];
            double[,] m2 = new double[n, n];
            double[,] mf = new double[n, n];

            Console.WriteLine("matrix aval :  ");
            MatrixRadif(m1, 0, n);
            Console.WriteLine("matrix dovom :  ");
            MatrixRadif(m2, 0, n);

            mf=MatrixZarb(m1, m2,n);


            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    Console.Write(mf[i, j]);
                    Console.Write("\t");
                }
                Console.Write("\n");
            }

        }

        static void MatrixRadif(double[,] m1, int i, int n)
        {
            if (i < n)
            {
                MatrixSoton(m1, i, 0, n);
                MatrixRadif(m1, i + 1, n);
            }
        }

        static void MatrixSoton(double[,] m1, int i, int j, int n)
        {
            if (j < n)
            {
                int x = Convert.ToInt32(Console.ReadLine());
                m1[i, j] = x;
                MatrixSoton(m1, i, j + 1, n);
            }
        }

        static double[,] MatrixZarb(double[,] m1, double[,] m2,int n)
        {
            double[,] mf = new double[n, n];

            return mf;
        }

        static double[,] zarb1(double[,] m1, double[,] m2,double[,] mf,int i , int j,int n)
        {
            mf[i,j]=



            return zarb1(m1, m2, mf, i, j + 1, n);
        }

        static double zarb2(double[,] m1, double[,] m2, double[,] mf, int i, int j, int n)
        {
            return (m1[i, 1] * m2[j, j]) + (m1[i, 2] * m2[j+1, j]) + (m1[i, 3] * m2[j+2, j]) + (m1[i, 4] * m2[j+3, j]);
        }





    }
}

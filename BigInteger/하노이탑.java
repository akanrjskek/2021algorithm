package BigInteger;

import java.math.*;
import java.util.Scanner;
public class �ϳ���ž{
    
    static void hanoi(int n, int start, int mid, int end) { 
        //n : �����ǰ���, start : ���۸����ȣ mid : ¡�˴ٸ� ���� ��ȣ end : �����������ȣ
        if (n == 1) {
            System.out.println(start+" "+end);
            return;
        }
 
        //n���� ������ ���������� �������� �ű�� ������ �Ʒ��� 3���� ��������
        //�ɰ��� ����.
        hanoi(n - 1, start, end, mid); 
        //1������ : n-1�� ������ ���۸��뿡�� ���� ���븦 ���� �߰������
        System.out.println(start+" "+end);
        //2������ : ���۸����� ������ ���� 1�� ������ ������ �����
        hanoi(n - 1, mid, start, end);
        //3������ : �߰������ �Ű�� n-1�� ������ �ٽ� ������ ����� �̵�.
        return;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger bi = new BigInteger("2");
        BigInteger c = bi.pow(n).subtract(BigInteger.ONE);
        System.out.println(c);
        if (n <= 20)
            hanoi(n, 1, 2, 3);
        
    }
 
}

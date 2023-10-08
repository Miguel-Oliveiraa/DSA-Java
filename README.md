
# Algoritmos e Estruturas de Dados em Java

Algoritmos implementados em Java, desenvolvidos durante a disciplina IF672 no Centro de Informática (CIn) da Universidade Federal de Pernambuco (UFPE).

## Dicas

### Use StringBuilder para Manipulação de Strings e Evite a função print

Quando estiver manipulando grandes volumes de texto em Java, especialmente dentro de loops ou operações intensivas, é crucial utilizar a classe StringBuilder. Ao contrário das strings convencionais em Java, que são imutáveis, o StringBuilder é mutável, permitindo modificações eficientes sem criar uma nova instância de string a cada iteração.

Uma razão adicional para adotar essa prática é que a função print do Java, especialmente quando usada repetidamente, não é performática. Cada chamada a System.out.print ou System.out.println gera uma operação de saída, o que pode ser bastante lento, especialmente quando você está trabalhando com grandes quantidades de dados.

Ao usar StringBuilder, você pode construir seu conteúdo de string eficientemente. Isso reduz drasticamente o número de operações de impressão, melhorando significativamente o desempenho do seu código.

Aqui está um exemplo prático:

```java
public class ExemploStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < 10000; i++) {
            builder.append("Número: " + i + "\n");
        }
        
        // Após construir a string, imprima apenas uma vez.
        System.out.print(builder);
    }
}

```

### Utilize o FastReader para receber as entradas

Em vez de depender do Scanner nativo do Java, que pode ser relativamente lento para grandes volumes de dados, considere utilizar o FastReader.

O FastReader é uma solução eficaz para leitura rápida de dados. Ele minimiza o tempo de entrada, permitindo que você leia valores de forma mais eficiente, resultando em um desempenho aprimorado do seu programa.

Aqui está um exemplo de como você pode utilizar o FastReader:

```java
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 

public class Main { 

    static FastReader s = new FastReader(); 

    public static void main(String[] args) { 
		int n = s.nextInt(); 
		int k = s.nextInt(); 
		int count = 0; 
		while (n-- > 0) { 
			int x = s.nextInt(); 
			if (x % k == 0) 
				count++; 
		} 
		System.out.println(count); 
	}

	static class FastReader { 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader( 
				new InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) { 
				try { 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) { 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() { return Integer.parseInt(next()); } 

		long nextLong() { return Long.parseLong(next()); } 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try { 
				if(st.hasMoreTokens()){ 
					str = st.nextToken("\n"); 
				} 
				else{ 
					str = br.readLine(); 
				} 
			} 
			catch (IOException e) { 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
}
```

#### Referência

Para obter informações detalhadas sobre técnicas de entrada eficiente em Java, incluindo o uso do FastReader em competições de programação, consulte o artigo "Fast I/O in Java in Competitive Programming" no GeeksforGeeks:

[Fast I/O in Java in Competitive Programming](https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/)

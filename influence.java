package makecolors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class influence {
	public static String FILENAME = "input/graph1.txt";
	
	static int targetSize = 5;
	static int M = 10;
	static int SIZE = getlinenum();
	static Deque<Integer> V = createNode(SIZE);	
	static float THRESHOLD = 0.1f;
	
	public static void main(String args[]){
		// 初期化
		int matrix[][] = getmatrix(SIZE);
		
		Deque<Integer> A = new ArrayDeque<Integer>();
		
		for(int i = 0; i < targetSize; i++){
			float maxinf = -1.0f;
			int selectedNode = -1;
			/*
			for(int v : arrayDiff(V, A)){
				if(maxinf < sigma(A, v)){
					maxinf = sigma(A, v);
					selectedNode = v;
				}
			}
			*/
			A.add(selectedNode);
		}
		System.out.println(A.toString());
	}
	
	public static float sigma(Deque<Integer> A){		
		float out;
		int x[][] = new int[arrayDiff(V, A).size()][M];
		for(int i = 1; i < M; i++){
			int G[][] = getRandomGraphIC(SIZE);
			computeF(G,A);
			
		}
		for(int v = 0; v < 2;/*すべてのノードから現状のノードを取り除いた数*/ v++){
			for(int m = 0; m < M; m++){
				
			}
		}
		
		return out;
		
		
		// matrixの中身確認
		/*
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		*/
	}
	public static Deque<Integer> createNode(int size){
		Deque<Integer> array = new ArrayDeque<Integer>();
		for(int i = 0; i < size; i++){
			array.add(i);
		}
		return array;
	}
	
	public static Deque<Integer> arrayDiff(Deque<Integer> A, Deque<Integer> B){
		Deque<Integer> result = new ArrayDeque<Integer>();
		for(int a : A){
			for(int b : B){
				if(a != b)
					result.add(a);
			}
		}
		return result;
	}
	
	public static int[][] getRandomGraphIC(int size){
		int matrix[][] = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(Math.random() > THRESHOLD){
					matrix[i][j] = 1;
				}
				else{
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
	
	public static int computeF(int matrix[][], Deque<Integer> A){
		int nodenum = 0;
		return nodenum;
	}
	
	public static int getlinenum(){
		int linenum = 0;
		try{
			FileReader in = new FileReader(FILENAME);
			BufferedReader br = new BufferedReader(in);
			//System.out.println("num: " + num + "in: " + in);
			while((br.readLine()) != null){
				linenum++;
			}
				//System.out.println("line" + line);
			br.close();
		} catch (IOException e){
			System.out.println(e);
		}
		return linenum;
	}
	
	public static int[][] getmatrix(int num){
		String line = "";
		int linenum = 0;
		int matrix[][] = new int[num][num];
		try{
			FileReader in = new FileReader(FILENAME);
			BufferedReader br = new BufferedReader(in);
			//System.out.println("num: " + num + "in: " + in);
			while((line = br.readLine()) != null){
				String[] a = line.split("\t");
				String[] split = a[1].split(",");
				for(int i = 0; i < num; i++){
					matrix[linenum][i] = Integer.parseInt(split[i]);
				}
				linenum++;
			}
			br.close();
		} catch (IOException e){
			System.out.println(e);
		}		
		return matrix;
	}
}

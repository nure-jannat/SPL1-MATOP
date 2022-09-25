
package spl;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class MATOP {
    
    public boolean debug = true;

	public boolean info = true;

	public static int max = 100;

	public static int decimals = 3;

	public JLabel statusBar;

	public JTextArea Matrix1, Matrix2, result;

	public int determinantFactor = 0;

	public int row,col;

	public static NumberFormat nf;

	public Component createComponents() {

		Matrix1 = new JTextArea();
		Matrix2 = new JTextArea();
		result = new JTextArea();
                result.setEditable(false);
                
		JPanel paneMs = new JPanel();
		paneMs.setLayout(new BoxLayout(paneMs, BoxLayout.X_AXIS));
		paneMs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		paneMs.add(MatrixPane("Matrix 1", Matrix1));
		paneMs.add(Box.createRigidArea(new Dimension(10, 0)));
		paneMs.add(MatrixPane("Matrix 2", Matrix2));
		paneMs.add(Box.createRigidArea(new Dimension(10, 0)));
		paneMs.add(MatrixPane("Result", result));

		JPanel paneBtn = new JPanel();
		paneBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		paneBtn.setLayout(new GridLayout(3, 4, 20, 25));
		JButton btnMatrix1AddMatrix2 = new JButton("Matrix1 + Matrix2 = Result");
                JButton btnMatrix1SubtractMatrix2 = new JButton("Matrix1 - Matrix2 = Result");
                JButton btnMatrix2SubtractMatrix1 = new JButton("Matrix2 - Matrix1 = Result");
		JButton btnMatrix1MultiplyMatrix2 = new JButton("Matrix1 * Matrix2 = Result");
		JButton btnMatrix2MultiplyMatrix1 = new JButton("Matrix2 * Matrix1 = Result");
		JButton btnAdjMatrix1 = new JButton("adjoint(Matrix1) = Result");
                JButton btnAdjMatrix2 = new JButton("adjoint(Matrix2) = Result");
		JButton btnInvMatrix1 = new JButton("inverse(Matrix1) = Result");
		JButton btnInvMatrix2 = new JButton("inverse(Matrix2) = Result");
		JButton btnTrnsMatrix1 = new JButton("transpose(Matrix1) = Result");
                JButton btnTrnsMatrix2 = new JButton("transpose(Matrix2) = Result");
		JButton btnDetMatrix1 = new JButton("determ(Matrix1) = Result");
		JButton btnDetMatrix2 = new JButton("determ(Matrix2) = Result");
                JButton btnRankMatrix1 = new JButton("Rank(Matrix1) = Result");
		JButton btnRankMatrix2 = new JButton("Rank(Matrix2) = Result");
                
		paneBtn.add(btnMatrix1AddMatrix2);
		paneBtn.add(btnMatrix1MultiplyMatrix2);
		paneBtn.add(btnMatrix2MultiplyMatrix1);
                paneBtn.add(btnMatrix1SubtractMatrix2);
		paneBtn.add(btnMatrix2SubtractMatrix1);
		paneBtn.add(btnAdjMatrix1);
                paneBtn.add(btnAdjMatrix2);
		paneBtn.add(btnInvMatrix1);
		paneBtn.add(btnInvMatrix2);
		paneBtn.add(btnTrnsMatrix1);
                paneBtn.add(btnTrnsMatrix2);
		paneBtn.add(btnDetMatrix1);
		paneBtn.add(btnDetMatrix2);
                paneBtn.add(btnRankMatrix1);
                paneBtn.add(btnRankMatrix2);

		btnMatrix1AddMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(AddMatrix(ReadInMatrix(Matrix1),
							ReadInMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
                btnMatrix1SubtractMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(SubtractMatrix(ReadInMatrix(Matrix1),
							ReadInMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
                btnMatrix2SubtractMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(SubtractMatrix(ReadInMatrix(Matrix2),
							ReadInMatrix(Matrix1)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnMatrix1MultiplyMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(MultiplyMatrix(ReadInMatrix(Matrix1),
							ReadInMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnMatrix2MultiplyMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(MultiplyMatrix(ReadInMatrix(Matrix2),
							ReadInMatrix(Matrix1)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnInvMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Inverse(SquareMatrix(Matrix1)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnInvMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Inverse(SquareMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnAdjMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Adjoint(SquareMatrix(Matrix1)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

                btnAdjMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Adjoint(SquareMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
                
		btnTrnsMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Transpose(ReadInMatrix(Matrix1)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
                btnTrnsMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					DisplayMatrix(Transpose(ReadInMatrix(Matrix2)), result);
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnDetMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					result.setText("Determinant of Matrix1: "
							+ nf.format(Determinant(SquareMatrix(Matrix1))));
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});

		btnDetMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					result.setText("Determinant of Matrix2: "
							+ nf.format(Determinant(SquareMatrix(Matrix2))));
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
               btnRankMatrix1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					result.setText("Rank of Matrix1: "
							+ nf.format(RankOfMatrix(ReadInMatrix(Matrix1))));
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                
                btnRankMatrix2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					result.setText("Rank of Matrix2: "
							+ nf.format(RankOfMatrix(ReadInMatrix(Matrix2))));
				} catch (Exception e) {
                                    JOptionPane.showMessageDialog(null, e);
					System.err.println("Error: " + e);
				}
			}
		});
                

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(paneMs);
		pane.add(paneBtn);

		JPanel fpane = new JPanel();
		fpane.setLayout(new BorderLayout());
		fpane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		fpane.add("Center", pane);
		statusBar = new JLabel("Ready");
		fpane.add("South", statusBar);

		return fpane;
	}

	private JPanel MatrixPane(String str, JTextArea ta) {
		JScrollPane scrollPane = new JScrollPane(ta);
		int size = 200;

		scrollPane.setPreferredSize(new Dimension(size, size));
		JLabel label = new JLabel(str);
		label.setLabelFor(scrollPane);

		JPanel pane = new JPanel();
		pane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
		pane.add(label);
		pane.add(scrollPane);

		return pane;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("MATOP");
		frame.setSize(new Dimension(725, 200));
                ImageIcon icon = new ImageIcon("C:\\Users\\janna\\OneDrive\\Documents\\NetBeansProjects\\MATOP\\src\\matop\\images.png");
                frame.setIconImage(icon.getImage());
		MATOP app = new MATOP();

		Component contents = app.createComponents();
		frame.getContentPane().add(contents, BorderLayout.CENTER);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);

		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(decimals);

	}

	
	public float[][] ReadInMatrix(JTextArea ta) throws Exception {
		if (debug) {
			System.out.println("Reading In Matrix");
		}
		
		String rawtext = ta.getText();
		String value = "";
		int i = 0;
		int j = 0;
		int[] rowSize = new int[max];

		StringTokenizer ts = new StringTokenizer(rawtext, ";");
		while (ts.hasMoreTokens()) {
			StringTokenizer ts2 = new StringTokenizer(ts.nextToken());
			while (ts2.hasMoreTokens()) {
				ts2.nextToken();
				j++;
			}
			rowSize[i] = j;
			i++;
			j = 0;
		}
		statusBar.setText("Matrix Size: " +i+"x"+rowSize[0]);
		if ((debug) || (info)) {
			System.out.println("Matrix Size: " +i+"x"+rowSize[0]);
		}

		
		row = i;
                col = rowSize[0];
		float matrix[][] = new float[row][col];
		i = j = 0;
		value = "";

		StringTokenizer st = new StringTokenizer(rawtext, ";");
		while (st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken());
			while (st2.hasMoreTokens()) {
				value = st2.nextToken();
				try {
					matrix[i][j] = Float.valueOf(value).floatValue();
				} catch (Exception exception) {
					statusBar.setText("Invalid Number Format");
				}
				j++;
			}
			i++;
			j = 0;
		}

		if (debug) {
			System.out.println("Matrix Read::");
			for (i = 0; i < row; i++) {
				for (j = 0; j < col; j++) {
					System.out.print("m[" + i + "][" + j + "] = "
							+ matrix[i][j] + "   ");
				}
				System.out.println();
			}
		}

		return matrix;
	}
        
        public float[][] SquareMatrix(JTextArea ta) throws Exception {
		if (debug) {
			System.out.println("Reading In Matrix");
		}

		String rawtext = ta.getText();
		String value = "";
		int i = 0;
		int j = 0;
		int[] rowSize = new int[max];

		
		StringTokenizer ts = new StringTokenizer(rawtext, ";");
		while (ts.hasMoreTokens()) {
			StringTokenizer ts2 = new StringTokenizer(ts.nextToken());
			while (ts2.hasMoreTokens()) {
				ts2.nextToken();
				j++;
			}
			rowSize[i] = j;
			i++;
			j = 0;
		}
		statusBar.setText("Matrix Size: " + i);
		if ((debug) || (info)) {
			System.out.println("Matrix Size: " + i);
		}

		for (int c = 0; c < i; c++) {
			if (debug) {
				System.out.println("i=" + i + "  j=" + rowSize[c] + "   Column: "
						+ c);
			}

			if (rowSize[c] != i) {
				statusBar.setText("Invalid Matrix Entered.Need Square Matrix.");
				throw new Exception("Invalid Matrix Entered. Need Square Matrix.");
			}
		}
		
		int n = i;

		float matrix[][] = new float[n][n];
		i = j = 0;
		value = "";

		
		StringTokenizer st = new StringTokenizer(rawtext, ";");
		while (st.hasMoreTokens()) {
			StringTokenizer st2 = new StringTokenizer(st.nextToken());
			while (st2.hasMoreTokens()) {
				value = st2.nextToken();
				try {
					matrix[i][j] = Float.valueOf(value).floatValue();
				} catch (Exception exception) {
					statusBar.setText("Invalid Number Format");
				}
				j++;
			}
			i++;
			j = 0;
		}

		if (debug) {
			System.out.println("Matrix Read::");
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					System.out.print("m[" + i + "][" + j + "] = "
							+ matrix[i][j] + "   ");
				}
				System.out.println();
			}
		}

		return matrix;
	}

        

	
	public void DisplayMatrix(float[][] matrix, JTextArea ta) {

		if (debug) {
			System.out.println("Displaying Matrix");
		}
		
		String resultString = "";
		String subResult = "";

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				subResult = nf.format(matrix[i][j]);
				resultString = resultString.concat(subResult + "  ");
			}

			resultString = resultString.concat("\n");
                        
		}
		ta.setText(resultString);
	}

        public float[][] AddMatrix(float[][] a, float[][] b) throws Exception {
		int row_a = a.length;
                int col_a = a[0].length;
		int row_b = b.length;
                int col_b = b[0].length;
		if (row_a != row_b || col_a!=col_b) {
			statusBar.setText("Matrix Size Mismatch");
                        throw new Exception("Matrix Size Mismatch");
		}

		float matrix[][] = new float[row_a][col_a];

		for (int i = 0; i < row_a; i++)
			for (int j = 0; j < col_a; j++) {
				matrix[i][j] = a[i][j] + b[i][j];
			}

		return matrix;
	}
        
        public float[][] SubtractMatrix(float[][] a, float[][] b) throws Exception {
		int row_a = a.length;
                int col_a = a[0].length;
		int row_b = b.length;
                int col_b = b[0].length;
		if (row_a != row_b || col_a!=col_b) {
			statusBar.setText("Matrix Size Mismatch");
                        throw new Exception("Matrix Size Mismatch");
		}

		float matrix[][] = new float[row_a][col_a];

		for (int i = 0; i < row_a; i++)
			for (int j = 0; j < col_a; j++) {
				matrix[i][j] = a[i][j] - b[i][j];
			}

		return matrix;
	}

	
	public float[][] MultiplyMatrix(float[][] a, float[][] b) throws Exception {
		
		if(a[0].length != b.length)
			throw new Exception("Matrices incompatible for multiplication");
		float matrix[][] = new float[a.length][b[0].length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < b[i].length; j++)
				matrix[i][j] = 0;

		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < b[i].length; j++){
                            for(int k = 0; k < b.length;k++){
                                matrix[i][j] += a[i][k]*b[k][j];
                            }
			}
		}
		return matrix;
	}

	
	
	public float[][] Transpose(float[][] a) {
		if (info) {
			System.out.println("Performing Transpose...");
		}
		
		float m[][] = new float[a[0].length][a.length];

		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[i].length; j++)
				m[j][i] = a[i][j];
		return m;
	}

	

	public float[][] Inverse(float[][] a) throws Exception {
		
		if (info) {
			System.out.println("Performing Inverse...");
		}
		int mSize = a.length;

		float m[][] = new float[mSize][mSize];
		float mm[][] = Adjoint(a);

		float det = Determinant(a);
		float dd = 0;

		if (det == 0) {
			statusBar.setText("Determinant Equals 0, Not Invertible.");
			if (info) {
				System.out.println("Determinant Equals 0, Not Invertible.");
			}
		} else {
			dd = 1 / det;
		}

		for (int i = 0; i < mSize; i++)
			for (int j = 0; j < mSize; j++) {
				m[i][j] = dd * mm[i][j];
			}

		return m;
	}

	

	public float[][] Adjoint(float[][] a) throws Exception {
		if (info) {
			System.out.println("Performing Adjoint...");
		}
		int mSize = a.length;

		float m[][] = new float[mSize][mSize];

		int ii, jj, ia, ja;
		float det;

		for (int i = 0; i < mSize; i++)
			for (int j = 0; j < mSize; j++) {
				ia = ja = 0;

				float ap[][] = new float[mSize - 1][mSize - 1];

				for (ii = 0; ii < mSize; ii++) {
					for (jj = 0; jj < mSize; jj++) {

						if ((ii != i) && (jj != j)) {
							ap[ia][ja] = a[ii][jj];
							ja++;
						}

					}
					if ((ii != i) && (jj != j)) {
						ia++;
					}
					ja = 0;
				}

				det = Determinant(ap);
				m[i][j] = (float) Math.pow(-1, i + j) * det;
			}

		m = Transpose(m);

		return m;
	}

	

	public float[][] UpperTriangle(float[][] matrix) {
		if (info) {
			System.out.println("Converting to Upper Triangle...");
		}
               float f1 = 0;
		float temp=0;
		int size = matrix.length; 
							
		int v = 1;

		determinantFactor  = 1;

		for (int col = 0; col < size - 1; col++) {
			for (int row = col + 1; row < size; row++) {
				v = 1;

				outahere: while (matrix[col][col] == 0) 
				{ 
					if (col + v >= size) 
					{
						determinantFactor  = 0;
						break outahere;
					} else {
						for (int c = 0; c < size; c++) {
							temp = matrix[col][c];
							matrix[col][c] = matrix[col + v][c]; 
							matrix[col + v][c] = temp;
						}
						v++; 
						determinantFactor  = determinantFactor  * -1; 
										
				}

				if (matrix[col][col] != 0) {
					if (debug) {
						System.out.println("Size = " + size + "   col = " + col
								+ "   row = " + row);
					}

					try {
						f1 = (-1) * matrix[row][col] / matrix[col][col];
						for (int i = col; i < size; i++) {
							matrix[row][i] = f1 * matrix[col][i] + matrix[row][i];
						}
					} catch (Exception e) {
						System.out.println("Still Here!!!");
					}

				}

			}
		}

		
	}
          return matrix;
    }
	

	public float Determinant(float[][] matrix) {
		if (info) {
			System.out.println("Getting Determinant...");
		}
		int mSize = matrix.length;

		float det = 1;

		matrix = UpperTriangle(matrix);

		for (int i = 0; i < mSize; i++) {
			det = det * matrix[i][i];
		} 

		det = det * determinantFactor; 

		if (info) {
			System.out.println("Determinant: " + det);
		}
		return det;
	}
        
        
        
        public int RankOfMatrix(float[][] matrix){
            if (info) {
			System.out.println("Getting Rank...");
		}
         int R = matrix.length;
         int C = matrix[0].length;
         int rank = C;
     
        for (int row = 0; row < rank; row++)
        {
            if (matrix[row][row] != 0)
            {
                for (int col = 0; col < R; col++)
                {
                    if (col != row)
                    {
                        float mult = matrix[col][row] /matrix[row][row];
                                     
                        for (int i = 0; i < rank; i++)
                         
                            matrix[col][i] -= mult* matrix[row][i];
                    }
                }
            }
     
            else
            {
                boolean reduce = true;
                for (int i = row + 1; i < R; i++)
                {
                    if (matrix[i][row] != 0)
                    {
                        swap(matrix, row, i, rank);
                        reduce = false;
                        break ;
                    }
                }
                
                if (reduce)
                {
                    rank--;
                    for (int i = 0; i < R; i ++)
                        matrix[i][row] = matrix[i][rank];
                }
                row--;
            }
 
        }
         
        return rank;
    }
        
        
     public void swap(float mat[][],
          int row1, int row2, int col)
    {
        for (int i = 0; i < col; i++)
        {
            float temp = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = temp;
        }
    }   
        
        

}


/*
Rank : 
Test case: 10 20 10;-20 -30 10;30 50 0
Test case:2 -1 3;1 0 1;0 2 -1;1 1 4 



*/

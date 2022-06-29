import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.lang.*;
public class IerarhieUniversitate{
	public static void main(String[] args){
		JFrame Universitate  = new JFrame("Universitate");
		Universitate.setSize(600, 600);
		Universitate.setVisible(true);
		Universitate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton butonProfesor = new JButton("Profesor");
		butonProfesor.setBounds(100, 250, 150, 100);
		butonProfesor.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Profesor profesor = new Profesor();
				Universitate.setVisible(false);
			}
		});
		JButton butonElev = new JButton("Elev");
		butonElev.setBounds(350, 250, 150, 100);
		butonElev.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Elev elev = new Elev();
				Universitate.setVisible(false);
			}
		});
		
		Universitate.add(butonProfesor);
		Universitate.add(butonElev);
		Universitate.setLayout(null);
		
		Profesor profesor = new Profesor();
		
	}
	
	
}

class Universitate{
	static ArrayList<String> usernameProfesorMatematica = new ArrayList<String>();
	static ArrayList<String> parolaProfesorMatematica = new ArrayList<String>();
	static ArrayList<String> usernameElev = new ArrayList<String>();
	static ArrayList<String> parolaElev = new ArrayList<String>();
	static String[] materii = {"Matematica", "Informatica", "T.I.C", "Lb. Romana"};
	
	static ArrayList<Integer> noteMatematica = new ArrayList<Integer>();
	
	
	void setUser(String username, String parola, int varianta,	int materie){
		if(varianta == 1){
			if(materie == 0){
				usernameProfesorMatematica.add(username);
				parolaProfesorMatematica.add(parola);
			}
		}
		else{
			usernameElev.add(username);
			parolaElev.add(parola);
		}
	}
	
	
	int getGrades(int materie, int IdElev){
		if(materie == 0){
			return noteMatematica.get(IdElev);
		}
		else{
			return 0;
		}
	}
	
	void setGrades(int materie, int IdElev, int nota){
		if(materie == 0){
			noteMatematica.set(IdElev, nota);
		}
	}
	
	
	
	
}

class Elev extends Universitate{
	
}

class Profesor extends Universitate{
		Profesor(){
			JFrame frameProfesor = new JFrame("Teacher Log In");
			
			frameProfesor.setSize(600, 600);
			
			
			
			//TextAreas
			JTextArea userTA = new JTextArea();
			userTA.setBounds(300, 100, 250, 50);
			
			JTextArea passTA = new JTextArea();
			passTA.setBounds(300, 200, 250, 50);
			//TextAreas
			
			//Labels
			JLabel userText = new JLabel("User", SwingConstants.CENTER);
			
			userText.setBounds(50, 100, 230, 30);
			
			
			
			JLabel passText = new JLabel("Password", SwingConstants.CENTER);
			
			passText.setBounds(50, 200, 230, 30);
			//Labels
			
			//JCB
			JComboBox<String> alegeMaterii = new JComboBox<>(Universitate.materii);
			alegeMaterii.setBounds(50, 300, 70, 50);
			
			//JCB
			
			//Buttons
			JButton register = new JButton("Register");
			register.setBounds(140, 300, 200, 100);
			register.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					boolean isAvailable = true;
					boolean isEmptyVar = false;
					if(userTA.getText().equals("") || passTA.getText().equals("")){
						isEmptyVar = true;
					}
					if(alegeMaterii.getSelectedIndex() == 0){
						for(int i = 0; i<Universitate.usernameProfesorMatematica.size(); i++){
							if(Universitate.usernameProfesorMatematica.get(i).equals(userTA.getText())){
								isAvailable = false;
								break;
							}
						}
					}
					
					if(isAvailable == true && isEmptyVar == false){
						setUser(userTA.getText(), passTA.getText(), 1, alegeMaterii.getSelectedIndex());
						
					}
					else if(isAvailable == false){
						JOptionPane.showMessageDialog(null, "Username-ul nu este disponibil", "Username-ul nu este disponibil", JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null, "Ambele campuri trebuie completate", "Ambele campuri trebuie completate", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			});
			
			JButton login = new JButton("Log In");
			login.setBounds(350, 300, 200, 100);
			login.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					
				}
			});
			//Buttons
			
			
			frameProfesor.setVisible(true);
			
			frameProfesor.add(userText);
			frameProfesor.add(passText);
			frameProfesor.add(userTA);
			frameProfesor.add(passTA);
			frameProfesor.add(register);
			frameProfesor.add(login);
			frameProfesor.add(alegeMaterii);
			frameProfesor.setLayout(null);
			
			
		}
}
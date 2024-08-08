package Encryption;
import java.util.*;

public class Encrypt {

    private Scanner sc;
    private Random Random;
    private ArrayList<Character> list;
    private ArrayList<Character> ShuffleList;
    private char ch;
    private String line;
    private char[] letters;
    
    
    public Encrypt(){
         sc = new Scanner(System.in);
         Random = new Random();
         list = new ArrayList();
         ShuffleList = new ArrayList();
         ch =' ';
        newKey();
        askQ();   
    }

    private void askQ(){
        while (true) {
        System.out.println("################################");
        System.out.println("What do you want to do ? ");
        System.out.println("N- New Key");
        System.out.println("G- Get Key");
        System.out.println("E- Encrypt");
        System.out.println("D- Decrypt");
        System.out.println("Q- Quit");
        System.out.println("###############################");
        char res = sc.next().toUpperCase().charAt(0);
        switch(res){
            case 'N':
                newKey();
                break;
            case 'G':
                getKey();
                break;
            case 'E':
                encrypt();
                break;
            case 'D':
                decrypt();
                break;
            case 'Q':
                Quit();
                break;
             default:
                System.out.println("Wrong Input");
                break;
            }       
        }
    }
    private void newKey(){
        ch = ' ';
        list.clear();
        ShuffleList.clear();

        for(int i = 32; i <= 126; i++){
            list.add(Character.valueOf(ch));
            ch++;
        }
        ShuffleList = new ArrayList(list);
        Collections.shuffle(ShuffleList);
        System.out.println("A new key has been created");
    }
    private void getKey(){
        System.out.println("key:-");
        for(Character i: list){
            System.out.print(i);
        }
        System.out.println();
        for(Character i: ShuffleList){
            System.out.print(i);
        }
        System.out.println();


    }
    private void encrypt(){
		System.out.println("Enter a message to be encrypted: ");
        line = sc.nextLine();
        
		//String message;
        String message = sc.nextLine();
		letters = message.toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=ShuffleList.get(j);
					break;
				}
			} 
        }
        System.out.println("Encrypted message:-");
        for(char x: letters) {
            System.out.print(x);
        }
        System.out.println();
    }
    private void decrypt(){
        System.out.println("Enter a message to be decrypted: ");
        line = sc.nextLine();
        
		//String message;
        String message = sc.nextLine();
		letters = message.toCharArray();
		
		for(int i =0;i<letters.length;i++) {
			
			for(int j =0;j<ShuffleList.size();j++) {
				if(letters[i]==ShuffleList.get(j)) {
					letters[i]=list.get(j);
					break;
				}
			} 
        }
        System.out.println("Decrypted message:-");
        for(char x: letters) {
            System.out.print(x);
        }
        System.out.println();

    }
    private void Quit(){
        System.out.println("Exiting...");
        System.exit(0);
    }

}

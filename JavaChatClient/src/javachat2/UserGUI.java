/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachat2;

import javax.swing.JOptionPane;

/**
 *
 * @author pyaks
 */
public class UserGUI implements Chat2UserInterface{

    @Override
    public void processCommands()
	 {
		 String[] commands = {"CHAT",
				 	"Search",
				 	"ADD",
				 	"BLock",
                                        "Delete",
                                        };
		 
		 int choice;
		 
		 do {
			
			 choice = JOptionPane.showOptionDialog(null,
					 "Select a command", 
					 "Chat User Option", 
					 JOptionPane.YES_NO_CANCEL_OPTION, 
					 JOptionPane.QUESTION_MESSAGE, 
					 null, 
					 commands,
					 commands[commands.length - 1])
					 
					 ;
                         
		 
			 switch (choice) {
                                case 0: Chat(); break;
			 	case 1: Search(); break;
			 	case 2: Add(); break;
			 	case 3: Block(); break;
			 	case 4: Delete(); break;
//                                case 4: doShowList(); break;
//                                case 5: doScroll(); break;
//                                case 6: doSelect(); break;
//			 	case 7: doSave(); break;
			 	default:  // do nothing
			 }
			 
		 } while (choice != commands.length-1);
		 System.exit(0);
	 }
    // to search for user
    public void Search(){
        
    }
    
    
    //to add user
    public void Add(){
        
    }

    // to Block
    public void Block(){
        
    }
    // to delete user
    
    public void Delete(){
        
    }
    // to chat with user
    public void Chat(){
        ChatFrame fff = new ChatFrame();
        
        
    }
}

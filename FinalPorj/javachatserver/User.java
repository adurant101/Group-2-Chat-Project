/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javachatserver;


public class User {
        private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
	public boolean isValid (String u, String p)
	{
        System.out.printf ("IsValid: %s/%s\n", u, p);
		return u.equals(username) && p.equals(password);
    }
    private static final String TO_STRING = "{\"username\": \"%s\"}";
    public String toString()
    {
        return String.format(TO_STRING, username);
    }
}

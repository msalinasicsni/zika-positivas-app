package ni.org.ics.zikapositivas.appmovil.domain.users;

import java.io.Serializable;

public class AuthorityId implements Serializable {
	/**
	 * Objeto que representa la clave unica de un rol
	 * 
	 * @author William Aviles
	 **/
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String authority;
	
	public AuthorityId(){
		
	}
	
	public AuthorityId(String username, String authority) {
		super();
		this.username = username;
		this.authority = authority;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuthorityId))
			return false;
		AuthorityId castOther = (AuthorityId) other;

		return (this.getUsername() == castOther.getUsername())
				&& (this.getAuthority() == castOther.getAuthority());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * 3;
		return result;	
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString(){
		return username;
	}

}
package ni.org.ics.zikapositivas.appmovil.domain.users;

/**
 * Simple objeto de dominio que representa un rol
 * 
 * 
 * @author William Aviles
 **/

public class Rol {
	private String authority;
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString(){
		return authority;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Rol))
			return false;
		
		Rol castOther = (Rol) other;

		return (this.getAuthority().equals(castOther.getAuthority()));
	}
}

package ni.org.ics.zikapositivas.appmovil.domain.users;

import java.util.Date;

import ni.org.ics.zikapositivas.appmovil.domain.BaseMetaData;

/**
 * Simple objeto de dominio que representa un rol para un usuario
 * 
 * @author William Aviles
 **/

public class Authority extends BaseMetaData{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AuthorityId authId;
	private UserSistema user;
	private Rol rol;
	
	public Authority() {
	}
	
	public Authority(AuthorityId authId, UserSistema user, Rol rol) {
		super();
		this.authId = authId;
		this.user = user;
		this.rol = rol;
	}
	
	public Authority(AuthorityId authId,
			Date recordDate, String recordUser) {
		super(recordDate, recordUser);
		this.authId = authId;
	}
	
	public Authority(AuthorityId authId,
			UserSistema user, Rol rol,Date recordDate, String recordUser) {
		super(recordDate, recordUser);
		this.authId = authId;
		this.user = user;
		this.rol = rol;
	}
	
	public AuthorityId getAuthId() {
		return authId;
	}
	public void setAuthId(AuthorityId authId) {
		this.authId = authId;
	}
	
	public UserSistema getUser() {
		return user;
	}
	
	public void setUser(UserSistema user) {
		this.user = user;
	}

	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	@Override
	public String toString(){
		return authId.getAuthority();
	}
	
}

package ni.org.ics.zikapositivas.appmovil.domain.users;

import java.util.Date;


/**
 * Simple objeto de dominio que representa un usuario
 * 
 * @author William Aviles
 **/

public class UserSistema  {
	private String username;
	private Date created;
	private Date modified;
	private Date lastAccess;
	private String password;
	private String completeName;
	private String email;
	private Boolean enabled=true;
	private Boolean accountNonExpired=true;
	private Boolean credentialsNonExpired=true;
	private Date lastCredentialChange;
	private Boolean accountNonLocked=true;
	private String createdBy;
	private String modifiedBy;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastAccess() {
		return lastAccess;
	}
	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}
	public Date getLastCredentialChange() {
		return lastCredentialChange;
	}
	public void setLastCredentialChange(Date lastCredentialChange) {
		this.lastCredentialChange = lastCredentialChange;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}	
	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Override
	public String toString(){
		return username;
	}
	@Override
	public boolean equals(Object other) {
		
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserSistema))
			return false;
		
		UserSistema castOther = (UserSistema) other;

		return (this.getUsername().equals(castOther.getUsername()));
	}
	
	@Override
	public int hashCode(){
		int result = 0;
		result = 31*result + (username !=null ? username.hashCode() : 0);
		return result;
	}
}

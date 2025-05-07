/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Entity;
/*    */ 
/*    */ 
/*    */ @Document(collection = "Surveyor")
/*    */ public class Surveyor {
/*    */   @Id
/*    */   private ObjectId SurveyorId;
/*    */   @Indexed(unique = true)
/*    */   @NonNull
/*    */   private String username;
/*    */   @NonNull
/*    */   private String name;
/*    */   
/*    */   @Generated
/* 15 */   public void setSurveyorId(ObjectId SurveyorId) { this.SurveyorId = SurveyorId; } @NonNull private String email; @NonNull private String password; private String picturename; private String imgurl; @Generated public void setUsername(@NonNull String username) { if (username == null) throw new NullPointerException("username is marked non-null but is null");  this.username = username; } @Generated public void setName(@NonNull String name) { if (name == null) throw new NullPointerException("name is marked non-null but is null");  this.name = name; } @Generated public void setEmail(@NonNull String email) { if (email == null) throw new NullPointerException("email is marked non-null but is null");  this.email = email; } @Generated public void setPassword(@NonNull String password) { if (password == null) throw new NullPointerException("password is marked non-null but is null");  this.password = password; } @Generated public void setPicturename(String picturename) { this.picturename = picturename; } @Generated public void setImgurl(String imgurl) { this.imgurl = imgurl; } @Generated public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.Survencee.Suvencee.Entity.Surveyor)) return false;  com.Survencee.Suvencee.Entity.Surveyor other = (com.Survencee.Suvencee.Entity.Surveyor)o; if (!other.canEqual(this)) return false;  Object this$SurveyorId = getSurveyorId(), other$SurveyorId = other.getSurveyorId(); if ((this$SurveyorId == null) ? (other$SurveyorId != null) : !this$SurveyorId.equals(other$SurveyorId)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$name = getName(), other$name = other.getName(); if ((this$name == null) ? (other$name != null) : !this$name.equals(other$name)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); if ((this$password == null) ? (other$password != null) : !this$password.equals(other$password)) return false;  Object this$picturename = getPicturename(), other$picturename = other.getPicturename(); if ((this$picturename == null) ? (other$picturename != null) : !this$picturename.equals(other$picturename)) return false;  Object this$imgurl = getImgurl(), other$imgurl = other.getImgurl(); return !((this$imgurl == null) ? (other$imgurl != null) : !this$imgurl.equals(other$imgurl)); } @Generated protected boolean canEqual(Object other) { return other instanceof com.Survencee.Suvencee.Entity.Surveyor; } @Generated public int hashCode() { int PRIME = 59; result = 1; Object $SurveyorId = getSurveyorId(); result = result * 59 + (($SurveyorId == null) ? 43 : $SurveyorId.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $name = getName(); result = result * 59 + (($name == null) ? 43 : $name.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $password = getPassword(); result = result * 59 + (($password == null) ? 43 : $password.hashCode()); Object $picturename = getPicturename(); result = result * 59 + (($picturename == null) ? 43 : $picturename.hashCode()); Object $imgurl = getImgurl(); return result * 59 + (($imgurl == null) ? 43 : $imgurl.hashCode()); } @Generated public String toString() { return "Surveyor(SurveyorId=" + String.valueOf(getSurveyorId()) + ", username=" + getUsername() + ", name=" + getName() + ", email=" + getEmail() + ", password=" + getPassword() + ", picturename=" + getPicturename() + ", imgurl=" + getImgurl() + ")"; } @Generated
/*    */   public Surveyor(ObjectId SurveyorId, @NonNull String username, @NonNull String name, @NonNull String email, @NonNull String password, String picturename, String imgurl) {
/* 17 */     if (username == null) throw new NullPointerException("username is marked non-null but is null");  if (name == null) throw new NullPointerException("name is marked non-null but is null");  if (email == null) throw new NullPointerException("email is marked non-null but is null");  if (password == null) throw new NullPointerException("password is marked non-null but is null");  this.SurveyorId = SurveyorId; this.username = username; this.name = name; this.email = email; this.password = password; this.picturename = picturename; this.imgurl = imgurl;
/*    */   } @Generated
/*    */   public Surveyor() {}
/*    */   @Generated
/* 21 */   public ObjectId getSurveyorId() { return this.SurveyorId; }
/*    */   @NonNull
/*    */   @Generated
/* 24 */   public String getUsername() { return this.username; } @NonNull
/*    */   @Generated
/* 26 */   public String getName() { return this.name; } @NonNull
/*    */   @Generated
/* 28 */   public String getEmail() { return this.email; } @NonNull
/*    */   @Generated
/* 30 */   public String getPassword() { return this.password; } @Generated
/* 31 */   public String getPicturename() { return this.picturename; } @Generated
/* 32 */   public String getImgurl() { return this.imgurl; }
/*    */ 
/*    */ }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Entity\Surveyor.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */
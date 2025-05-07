/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Entity;
/*    */ @Document(collection = "Reporters")
/*    */ public class Reporter { @Id
/*    */   private ObjectId repId;
/*    */   @Indexed(unique = true)
/*    */   @NonNull
/*    */   private String repoUsername;
/*    */   @NonNull
/*    */   private String reporter_name;
/*    */   
/*    */   @Generated
/* 12 */   public void setRepId(ObjectId repId) { this.repId = repId; } @NonNull private String channel_name; @NonNull private String email; @NonNull private String password; @Generated public void setRepoUsername(@NonNull String repoUsername) { if (repoUsername == null) throw new NullPointerException("repoUsername is marked non-null but is null");  this.repoUsername = repoUsername; } @Generated public void setReporter_name(@NonNull String reporter_name) { if (reporter_name == null) throw new NullPointerException("reporter_name is marked non-null but is null");  this.reporter_name = reporter_name; } @Generated public void setChannel_name(@NonNull String channel_name) { if (channel_name == null) throw new NullPointerException("channel_name is marked non-null but is null");  this.channel_name = channel_name; } @Generated public void setEmail(@NonNull String email) { if (email == null) throw new NullPointerException("email is marked non-null but is null");  this.email = email; } @Generated public void setPassword(@NonNull String password) { if (password == null) throw new NullPointerException("password is marked non-null but is null");  this.password = password; } @Generated public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.Survencee.Suvencee.Entity.Reporter)) return false;  com.Survencee.Suvencee.Entity.Reporter other = (com.Survencee.Suvencee.Entity.Reporter)o; if (!other.canEqual(this)) return false;  Object this$repId = getRepId(), other$repId = other.getRepId(); if ((this$repId == null) ? (other$repId != null) : !this$repId.equals(other$repId)) return false;  Object this$repoUsername = getRepoUsername(), other$repoUsername = other.getRepoUsername(); if ((this$repoUsername == null) ? (other$repoUsername != null) : !this$repoUsername.equals(other$repoUsername)) return false;  Object this$reporter_name = getReporter_name(), other$reporter_name = other.getReporter_name(); if ((this$reporter_name == null) ? (other$reporter_name != null) : !this$reporter_name.equals(other$reporter_name)) return false;  Object this$channel_name = getChannel_name(), other$channel_name = other.getChannel_name(); if ((this$channel_name == null) ? (other$channel_name != null) : !this$channel_name.equals(other$channel_name)) return false;  Object this$email = getEmail(), other$email = other.getEmail(); if ((this$email == null) ? (other$email != null) : !this$email.equals(other$email)) return false;  Object this$password = getPassword(), other$password = other.getPassword(); return !((this$password == null) ? (other$password != null) : !this$password.equals(other$password)); } @Generated protected boolean canEqual(Object other) { return other instanceof com.Survencee.Suvencee.Entity.Reporter; } @Generated public int hashCode() { int PRIME = 59; result = 1; Object $repId = getRepId(); result = result * 59 + (($repId == null) ? 43 : $repId.hashCode()); Object $repoUsername = getRepoUsername(); result = result * 59 + (($repoUsername == null) ? 43 : $repoUsername.hashCode()); Object $reporter_name = getReporter_name(); result = result * 59 + (($reporter_name == null) ? 43 : $reporter_name.hashCode()); Object $channel_name = getChannel_name(); result = result * 59 + (($channel_name == null) ? 43 : $channel_name.hashCode()); Object $email = getEmail(); result = result * 59 + (($email == null) ? 43 : $email.hashCode()); Object $password = getPassword(); return result * 59 + (($password == null) ? 43 : $password.hashCode()); } @Generated public String toString() { return "Reporter(repId=" + String.valueOf(getRepId()) + ", repoUsername=" + getRepoUsername() + ", reporter_name=" + getReporter_name() + ", channel_name=" + getChannel_name() + ", email=" + getEmail() + ", password=" + getPassword() + ")"; } @Generated
/*    */   public Reporter(ObjectId repId, @NonNull String repoUsername, @NonNull String reporter_name, @NonNull String channel_name, @NonNull String email, @NonNull String password) {
/* 14 */     if (repoUsername == null) throw new NullPointerException("repoUsername is marked non-null but is null");  if (reporter_name == null) throw new NullPointerException("reporter_name is marked non-null but is null");  if (channel_name == null) throw new NullPointerException("channel_name is marked non-null but is null");  if (email == null) throw new NullPointerException("email is marked non-null but is null");  if (password == null) throw new NullPointerException("password is marked non-null but is null");  this.repId = repId; this.repoUsername = repoUsername; this.reporter_name = reporter_name; this.channel_name = channel_name; this.email = email; this.password = password;
/*    */   } @Generated
/*    */   public Reporter() {}
/*    */   @Generated
/* 18 */   public ObjectId getRepId() { return this.repId; }
/*    */   @NonNull
/*    */   @Generated
/* 21 */   public String getRepoUsername() { return this.repoUsername; } @NonNull
/*    */   @Generated
/* 23 */   public String getReporter_name() { return this.reporter_name; } @NonNull
/*    */   @Generated
/* 25 */   public String getChannel_name() { return this.channel_name; } @NonNull
/*    */   @Generated
/* 27 */   public String getEmail() { return this.email; } @NonNull
/*    */   @Generated
/* 29 */   public String getPassword() { return this.password; }
/*    */    }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Entity\Reporter.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */
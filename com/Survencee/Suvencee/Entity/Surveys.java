/*    */ package BOOT-INF.classes.com.Survencee.Suvencee.Entity;@Document(collection = "Survey")
/*    */ public class Surveys { @Id
/*    */   private ObjectId id; @NonNull
/*    */   private String username; @NonNull
/*    */   private String title; @NonNull
/*    */   private ArrayList<String> proofs; @NonNull
/*    */   private String Surveys;
/*    */   private int likes;
/*    */   private ArrayList<String> like;
/*    */   private HashMap<String, String> comments;
/*    */   private int comment;
/*    */   private int views;
/*    */   
/*    */   @Generated
/* 15 */   public void setId(ObjectId id) { this.id = id; } @Generated public void setUsername(@NonNull String username) { if (username == null) throw new NullPointerException("username is marked non-null but is null");  this.username = username; } @Generated public void setTitle(@NonNull String title) { if (title == null) throw new NullPointerException("title is marked non-null but is null");  this.title = title; } @Generated public void setProofs(@NonNull ArrayList<String> proofs) { if (proofs == null) throw new NullPointerException("proofs is marked non-null but is null");  this.proofs = proofs; } @Generated public void setSurveys(@NonNull String str) { if (str == null) throw new NullPointerException("Surveys is marked non-null but is null");  this.Surveys = str; } @Generated public void setLikes(int likes) { this.likes = likes; } @Generated public void setLike(ArrayList<String> like) { this.like = like; } @Generated public void setComments(HashMap<String, String> comments) { this.comments = comments; } @Generated public void setComment(int comment) { this.comment = comment; } @Generated public void setViews(int views) { this.views = views; } @Generated public boolean equals(Object o) { if (o == this) return true;  if (!(o instanceof com.Survencee.Suvencee.Entity.Surveys)) return false;  com.Survencee.Suvencee.Entity.Surveys other = (com.Survencee.Suvencee.Entity.Surveys)o; if (!other.canEqual(this)) return false;  if (getLikes() != other.getLikes()) return false;  if (getComment() != other.getComment()) return false;  if (getViews() != other.getViews()) return false;  Object this$id = getId(), other$id = other.getId(); if ((this$id == null) ? (other$id != null) : !this$id.equals(other$id)) return false;  Object this$username = getUsername(), other$username = other.getUsername(); if ((this$username == null) ? (other$username != null) : !this$username.equals(other$username)) return false;  Object this$title = getTitle(), other$title = other.getTitle(); if ((this$title == null) ? (other$title != null) : !this$title.equals(other$title)) return false;  Object<String> this$proofs = (Object<String>)getProofs(), other$proofs = (Object<String>)other.getProofs(); if ((this$proofs == null) ? (other$proofs != null) : !this$proofs.equals(other$proofs)) return false;  Object this$Surveys = getSurveys(), other$Surveys = other.getSurveys(); if ((this$Surveys == null) ? (other$Surveys != null) : !this$Surveys.equals(other$Surveys)) return false;  Object<String> this$like = (Object<String>)getLike(), other$like = (Object<String>)other.getLike(); if ((this$like == null) ? (other$like != null) : !this$like.equals(other$like)) return false;  Object<String, String> this$comments = (Object<String, String>)getComments(), other$comments = (Object<String, String>)other.getComments(); return !((this$comments == null) ? (other$comments != null) : !this$comments.equals(other$comments)); } @Generated protected boolean canEqual(Object other) { return other instanceof com.Survencee.Suvencee.Entity.Surveys; } @Generated public int hashCode() { int PRIME = 59; result = 1; result = result * 59 + getLikes(); result = result * 59 + getComment(); result = result * 59 + getViews(); Object $id = getId(); result = result * 59 + (($id == null) ? 43 : $id.hashCode()); Object $username = getUsername(); result = result * 59 + (($username == null) ? 43 : $username.hashCode()); Object $title = getTitle(); result = result * 59 + (($title == null) ? 43 : $title.hashCode()); Object<String> $proofs = (Object<String>)getProofs(); result = result * 59 + (($proofs == null) ? 43 : $proofs.hashCode()); Object $Surveys = getSurveys(); result = result * 59 + (($Surveys == null) ? 43 : $Surveys.hashCode()); Object<String> $like = (Object<String>)getLike(); result = result * 59 + (($like == null) ? 43 : $like.hashCode()); Object<String, String> $comments = (Object<String, String>)getComments(); return result * 59 + (($comments == null) ? 43 : $comments.hashCode()); } @Generated public String toString() { return "Surveys(id=" + String.valueOf(getId()) + ", username=" + getUsername() + ", title=" + getTitle() + ", proofs=" + String.valueOf(getProofs()) + ", Surveys=" + getSurveys() + ", likes=" + getLikes() + ", like=" + String.valueOf(getLike()) + ", comments=" + String.valueOf(getComments()) + ", comment=" + getComment() + ", views=" + getViews() + ")"; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Generated
/*    */   public Surveys(ObjectId id, @NonNull String username, @NonNull String title, @NonNull ArrayList<String> proofs, @NonNull String str1, int likes, ArrayList<String> like, HashMap<String, String> comments, int comment, int views)
/*    */   {
/* 29 */     this.likes = 0;
/* 30 */     this.like = new ArrayList<>();
/* 31 */     this.comments = new HashMap<>();
/* 32 */     this.comment = 0;
/* 33 */     this.views = 0; if (username == null) throw new NullPointerException("username is marked non-null but is null");  if (title == null) throw new NullPointerException("title is marked non-null but is null");  if (proofs == null) throw new NullPointerException("proofs is marked non-null but is null");  if (str1 == null) throw new NullPointerException("Surveys is marked non-null but is null");  this.id = id; this.username = username; this.title = title; this.proofs = proofs; this.Surveys = str1; this.likes = likes; this.like = like; this.comments = comments; this.comment = comment; this.views = views; } @Generated public Surveys() { this.likes = 0; this.like = new ArrayList<>(); this.comments = new HashMap<>(); this.comment = 0; this.views = 0; } @Generated public ObjectId getId() { return this.id; } @NonNull @Generated public String getUsername() { return this.username; } @Generated public int getViews() { return this.views; }
/*    */ 
/*    */   
/*    */   @NonNull
/*    */   @Generated
/*    */   public String getTitle() {
/*    */     return this.title;
/*    */   }
/*    */   
/*    */   @NonNull
/*    */   @Generated
/*    */   public ArrayList<String> getProofs() {
/*    */     return this.proofs;
/*    */   }
/*    */   
/*    */   @NonNull
/*    */   @Generated
/*    */   public String getSurveys() {
/*    */     return this.Surveys;
/*    */   }
/*    */   
/*    */   @Generated
/*    */   public int getLikes() {
/*    */     return this.likes;
/*    */   }
/*    */   
/*    */   @Generated
/*    */   public ArrayList<String> getLike() {
/*    */     return this.like;
/*    */   }
/*    */   
/*    */   @Generated
/*    */   public HashMap<String, String> getComments() {
/*    */     return this.comments;
/*    */   }
/*    */   
/*    */   @Generated
/*    */   public int getComment() {
/*    */     return this.comment;
/*    */   } }


/* Location:              C:\Users\AVITA\OneDrive\Desktop\New folder (2)\Survencee-0.0.1-SNAPSHOT.jar!\BOOT-INF\classes\com\Survencee\Suvencee\Entity\Surveys.class
 * Java compiler version: 24 (68.0)
 * JD-Core Version:       1.1.3
 */
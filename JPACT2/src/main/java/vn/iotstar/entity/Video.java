package vn.iotstar.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Column(name="VideoId")
	 private int videoid;
	 @Column(name="Active")
	 private int active;
	 @Column(name="Description", columnDefinition = "nvarchar(500) null")
	 private String description;
	 @Column(name="Poster", columnDefinition = "nvarchar(500) null")
	 private String poster;
	 @Column(name="Title", columnDefinition = "nvarchar(500) null")
	 private String title;
	 @Column(name="Views")
	 private int views;
	 @ManyToOne
	 @JoinColumn(name="categoryId")
	 private Category category;

//	 @OneToMany(mappedBy="video")
//	 private List<Favorite> favorites;
//	 //
//	 @OneToMany(mappedBy="video")
//	 private List<Share> shares;
//	 
//	 public Favorite addFavorite(Favorite favorite) {
//
//
//		 getFavorites().add(favorite);
//
//
//		 favorite.setVideo(this);
//
//
//
//		 return favorite;
//
//
//		 }
//	 public Favorite removeFavorite(Favorite favorite) {
//
//
//		 getFavorites().remove(favorite);
//
//
//		 favorite.setVideo(null);
//
//
//
//		 return favorite;
//
//
//		 }
//	 public Share addShare(Share share) {
//
//
//		 getShares().add(share);
//
//
//		 share.setVideo(this);
//
//
//
//		 return share;
//
//
//		 }
//	 public Share removeShare(Share share) {
//
//
//		 getShares().remove(share);
//
//
//		 share.setVideo(null);
//
//
//
//		 return share;
//
//
//		 }
//
//

}

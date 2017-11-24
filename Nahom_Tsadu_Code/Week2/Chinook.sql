--Nahom Tsadu
--in-class join assignment

select customer.firstname, 
       invoiceline.quantity, 
       invoice.total, 
       mediatype.name as "MEDIA TYPE", 
       track.name as "TRACK NAME", 
       album.title as "ALBUM TITLE",
       genre.name as "GENRE",
       playlist.name as "PLAYLIST"
from customer
inner join invoice on invoice.customerid = customer.customerid
inner join invoiceline on invoiceline.invoiceid = invoice.invoiceid
inner join track on track.trackid = invoiceline.trackid
inner join album on album.albumid = track.trackid
inner join mediatype on mediatype.mediatypeid = track.mediatypeid
inner join genre on genre.genreid = track.genreid
inner join playlisttrack on playlisttrack.trackid = track.trackid
inner join playlist on playlist.playlistid = playlisttrack.playlistid;

select playlisttrack.playlistid, count(playlisttrack.trackid) from playlisttrack;

--inner join playlisttrack on pla
select playlisttrack.playlistid, count(playlisttrack.trackid) from playlisttrack group by playlisttrack.playlistid;
--ylisttrack.playlistid = playlist.playlistid;


--track.name, album.name 
--inner join track on track.trackid = invoice.trackid
--inner join album on album.albumid = track.albumid;
# Assignment9 การใช้ SQL กับ Andriod
![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
![alt text](https://github.com/prakasitz/Assignment9/blob/master/main.png "main")
### ไฟล์ที่แก้ทั้งหมด
ไฟล์ .xml
| ชื่อ  |path |
| ------ | ------ |
| activity_add_contact.xml | [res/layout/activity_add_contact.xml][PlDb] |
| activity_detail.xml | [res/layout/activity_detail.xml][PlGh] |
| activity_main.xml | [res/layout/activity_main.xml][PlOd] |
| activity_search_contact.xml | [res/layout/activity_search_contact.xml][PlMe] |
| contact_item.xml | [res/layout/contact_item.xml][PlGa] |
ไฟล์ .java
| ชื่อ  |path |
| ------ | ------ |
| AddContactActivity.java | [week9/activity/AddContactActivity.java][ja] |
| DetailActivity.java | [week9/activity/DetailActivity.java][jb] |
| ListContactActivity.java | [week9/activity/ListContactActivity.java][jc] |
| MainActivity.java | [week9/activity/MainActivity.javal][jd] |
| SearchContactActivity.java | [week9/activity/SearchContactActivity.java][je] |
|ContactAdapter.java|[week9/adapter/ContactAdapter.java][jf]
|Contact.java|[week9/model/Contact.java][jg]
|DBHelper.java|[week9/util/DBHelper.java][jh]

---

คอนเซปจริงๆไม่รู้ รู้แค่ว่าเอาของอาจารย์มาแก้ สรุปได้ดังนี้

  - เปลี่ยน คำว่า contract เป็น Employee ทั้ง project อะ ยกเว้นชื่อไฟล์ และชื่อโปรเจคเปลี่ยนไม่ได้!
  - โจทย์มีส่วนที่เป็น Age เป็น Int และ Salary เป็น Double ต้องไล่เปลี่ยน(เยอะมาก)
  - จากข้างบน ถ้าเรา getText ต้อง .toString() และอย่าลืมว่าต้องแปลง String เป็น type ที่ต้องการ
  - ถ้าเรา setText ต้องแปลงจาก type นั้นๆเป็น String อันนี้ไม่ต้องคิดไรมาก ใช้ String.valueOf(..)
  - แนะนำว่าถ้าจะเปลี่ยนชื่อ Method ใน Contract class จะแก้เยอะมาก อย่าเปลี่ยนดีกว่า


> "ทำความเข้าใจเรื่อง Adepter Class อันนี้น่าจะออกแน่นอน ว่ามีทำไม?
> เรื่อง Intent สำคัญมากในการส่งค่า

### ดู Error
  - ถ้าตอน กดรันแล้วมันขึ้น complier error แสดงว่าเป็นที่ syntax ผิดแน่ๆ ต้องไล่หาว่าตรงไหน.. ส่วนใหญ่จะเป็นที่ การส่งค่ารับค่า type ไม่ตรงกัน หรือการ setText และ getText ที่ type ไม่ตรงกัน
  - ถ้ารันผ่านแต่กด Menu แล้วไม่รอด อันนั้นต้องดูที่ Onclick ดูว่าใน Onclick มีตรงไหนแดงไหมหรือมีเรียก DBHelper ไหม ถ้ามี ต้องไปดูดีๆ เรื่อง SELECT,DELETE,UPDATE มันถูกไหม
  - ถ้าเทส INSERT , UPDATE หรือ DELETE ไม่เข้า หรือเด้ง เป็นที่ DBHelper แน่ๆ
  - ถ้าเครื่องมันขึ้น Error apk หรือ sdk ให้ไปหน้า activity_main.xml
  - (ต่อ) Design เลือก icon Andriod เขียวๆ จาก 28 เป็น > 23 



   [PlDb]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/res/layout/activity_add_contact.xml>
   [PlGh]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/res/layout/activity_detail.xml>
   [PlOd]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/res/layout/activity_main.xml>
   [PlMe]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/res/layout/activity_search_contact.xml>
   [PlGa]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/res/layout/contact_item.xml>
   
   
   [ja]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/activity/AddContactActivity.java>
   [jb]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/activity/DetailActivity.java>
   [jc]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/activity/ListContactActivity.java>
   [jd]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/activity/MainActivity.java>
   [je]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/activity/SearchContactActivity.java>
   [jf]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/adapter/ContactAdapter.java>
   [jg]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/model/Contact.java>
   [jh]: <https://github.com/prakasitz/Assignment9/blob/master/app/src/main/java/com/mydomain/app/week9/util/DBHelper.java>
   
   
   

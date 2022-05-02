# Encryption_Decryption
At the start of my project, I built a base concept around the Caesar cipher. Then after I have finished the base of my code I decided to create a new and tricky encryption way. I started by thinking if I can use the random factor in which each letter can be encrypted differently each time and thus not enabling someone to decrypt my code. After taking my time, I found it hard to do so. I then thought of using 2D arrays to cut each word/String into a specific pattern and change the order of its letters. I went on relying on a zig-zag type of path. I divided my words in a n (n represent the key which is randomly generated each time you run the code) by the length of the word matrix.
To explain my strategy even further, I will use a matrix of 3 by the length of the word matrix. If I have the word “Charbel” (which is the msg in the first encryption method), the letters will be placed in a matrix in a zig-zag manner such as:


	
![image](https://user-images.githubusercontent.com/77696672/166236103-d277000a-04ff-4363-8eb6-1d6b2338f28c.png)



Then I decided to read the matrix in a horizontal manner (row by row) to get the output1, in this case as “cbhreal”( This is the decrypted text):



![image](https://user-images.githubusercontent.com/77696672/166236134-cf336f67-3a32-400a-ae1d-902125842f9b.png)



Then again, I put the output1 in a matrix in a zig-zag manner as I did in the first part. However, this time after putting the letters in a zig-zag manner, I replace the letters(after reading the matrix horizontally) such as c is replaced by the first letter of the output1 (c), e is replaced by the second letter of the output1(b), b is replaced by the third letter of the output 1(h)… this way we are rearranging the second matrix to be equal to the first matrix so we can read it in a zig-zag manner and get the original word:


![image](https://user-images.githubusercontent.com/77696672/166236158-2b123d48-4795-4964-8468-6f5bc16112c3.png)



The final step is to read the last matrix in a zig-zag manner.
I never gave up hope on the random factor. So to add the random factor, I created an array composed out of symbols, Latin letters and a random int generator, thus implementing them randomly around each letter confusing the person who is trying to decrypt it. Nevertheless, the major factor of the random items is the random key that is generated each time I run the code.
To make it even harder to decrypt, I removed the spaces between each word and encrypted it. This prevents the code to encrypt each word alone, instead, it will take all the paragraphs as one string and encrypt it. Thus, the output will be a cocktail of letters preventing the reader to know which letters form a specific word. I chose the key to be a big number because if one lucky reader can understand the encryption method and can guess the key I chose, it will take him/her more time to find the letters through this chaos of characters afterwards he/she has to put them in the right order, then he/she are going to have to draw an n by the length of the paragraph matrix , fill it in a horizontal  manner, read the letters in a zig-zag manner and finally separating each word alone.(bad punctuation , I know , I already passed the English course)

![image](https://user-images.githubusercontent.com/77696672/166236194-6b6200dc-f7bf-4ea6-9d28-bf6b33caca11.png)

Figure 1:This is an example of a matrix with a key=13, and that is only quarter of the first sentence. Imagine the whole paragraph

To conclude, if someone, by a miracle, can understand that the symbols and integers are randomly added and can figure out the key and which letters are for the same word and solve the matrix puzzle, I bet he has no life.
Sorry if I have explained it poorly but I tried my best to make it as clear as possible. I have added some comments in the code where you can see each step I am making.
P.S: All the decisions taken were based on the code running one time, which explains why my key is randomly chosen each time and not a fixed number


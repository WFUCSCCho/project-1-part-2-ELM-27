Program by Elliott Lowman
Assignment: Project 1, CSC201, fall 2024
Date: September 25, 2024

The data used for this program is stored in the CTB_Data.csv file.
    - The first column contains player usernames
    - The second column contains player account IDs
    - The third column contains player skill ratings
    - The fourth column contains player titles

The data used is part of a much larger database containing the skill rating for the top
    ~10000 players in osu!catch. I myself (Username: Owen123c, User ID: 12433794) am
    currently ranked 1,563 on this spreadsheet, though this may change by the next time the data is updated.

Access to this database can be found through this link:
    https://docs.google.com/spreadsheets/d/1s-ItBZwDzWb_taDPD2L2jrUbNzl4pxjSgXcE5dza4tc/edit?usp=sharing

The spreadsheet above contains much more data than is included in this project. This is for two reasons:
    1: Having so much data would be overwhelming to the viewer of the program
    2: Most of the data is simply used to calculate other parts of the data, primarily skill ratings and titles

For this reason, I have decided to only include usernames, account IDs, skill ratings, and titles, both for the
    simplicity of the program and since that's all that I would probably have to deal with.


TUTORIAL:
    The program works the same as the program from Part 1, though instead of any number being available
    to add, you must instead input a user ID. The list of user IDs can be found in the second column of
    CTB_Data.txt.

DISCLAIMER: I asked for permission from the developer of the game for use of this data set. I also asked permission
    from every user shown in my example input.txt to be used there.

    I know of at least one error in the program. If any two users are inputted who have the same skill rating, the one
    put in later will not be counted. This is because I could only get comparisons to work if they compared the skill
    values. If I tried to implement comparisons in any other way, the program would break.

    I would also like to apologize for any lack of quality in this program. I have been quite busy over the last couple
    of weeks, so I haven't had too much time to get this program to the quality that I would like to for a project.
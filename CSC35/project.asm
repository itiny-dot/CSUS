#Rachael Wang

.intel_syntax noprefix
.data

Intro:
    .ascii "Welcome to the wizard battle\nWritten by Rachael Wang\n\0"
Player:
     .ascii "\nPlayer \0"
HealthDisplay:
     .ascii "Health: \0"
TargetDisplay:
     .ascii "\nYour Target: \0"
PlayerQ:
    .ascii "\nHow many players? \0"
LastPlayer:
    .ascii "\nThe winner is\0"
AttackList:
    .ascii "\nPlease choose which player to attack \0"
SpellOne:
    .ascii "1. Cast Expelliarmus \n\0"
SpellTwo:
    .ascii "2. Cast Titillando \n\0"
SpellThree:
    .ascii "3. Cast Brackium Emendo \n\0"
Healed:
    .ascii "\nYou have healed for \0"
AttackMissed:
    .ascii "The attack has missed\n\0"
Died:
     .ascii " is dead\n\0"
Chance:
    .quad 0
AttackQ:
    .ascii "Which spell would you like to cast? \n\0"
NewLine:
     .ascii "\n\0"
Casts:
    .quad NewLine
    .quad SpellOne
    .quad SpellTwo
    .quad SpellThree
Choice:
     .quad 0
Players:
    .quad 0
Harry:
    .ascii " : Harry Potter\n\0"
Draco:
    .ascii " : Draco Malfoy\n\0"
Lord:
    .ascii " : Lord Voldemort\n\0"
Hermione:
    .ascii " : Hermione Granger\n\0"
Ron:
    .ascii " : Ron Weasley\n\0"
Fred:
    .ascii " : Fred Weasley\n\0"
George:
    .ascii " : George Weasley\n\0"
PlayerNames:
     .quad Harry
     .quad Draco
     .quad Lord
     .quad Hermione
     .quad Ron
     .quad Fred
     .quad George
CurrentPlayer:
    .quad 0
Survivors:
    .quad 0
Target:
    .quad 0
Taken:
    .quad 0
Damage:
    .ascii "Spell blasts them for \0"
Damage2:
    .ascii " points\n\0"
NumOfAttacks:
    .quad 4
Winner:
    .quad 0
Ghost:
    .ascii "        .-.\n"
    .ascii "      .'   `.\n"
    .ascii "     :g g   :\n"
    .ascii "     : o    `.\n"
    .ascii "  :         ``.\n"
    .ascii " :             `.\n"
    .ascii ":  :         .   `.\n"
    .ascii ":   :          ` . `.\n"
    .ascii " `.. :            `. ``;\n"
    .ascii "    `:;             `:'\n"
    .ascii "       :              `.\n"
    .ascii " jgs    `.              `.     .\n"
    .ascii "          `'`'`'`---..,___`;.-'\n\n\0"
Art:
    .ascii "                                         _ __                                \n"
    .ascii "         ___                             | '  \\                                \n"
    .ascii "    ___  \\ /  ___         ,'\\_           | .-. \\        /|                       \n"
    .ascii "    \\ /  | |,'__ \\  ,'\\_  |   \\          | | | |      ,' |_   /|                  \n"
    .ascii "  _ | |  | |\\/  \\ \\ |   \\ | |\\_|    _    | |_| |   _ '-. .-',' |_   _               \n"
    .ascii " // | |  | |____| | | |\\_|| |__    //    |     | ,'_`. | | '-. .-',' `. ,'\\_        \n"
    .ascii " \\\\_| |_,' .-, _  | | |   | |\\ \\  //    .| |\\_/ | / \\ || |   | | / |\\  \\|   \\           \n"
    .ascii "  `-. .-'| |/ / | | | |   | | \\ \\//     |  |    | | | || |   | | | |_\\ || |\\_|           \n"
    .ascii "    | |  | || \\_| | | |   /_\  \\ /      | |`    | | | || |   | | | .---'| |             \n"
    .ascii "    | |  | |\\___,_\\ /_\\ _      //       | |     | \\_/ || |   | | | |  /\\| |            \n"
    .ascii "    /_\\  | |           //_____//       .||`      `._,' | |   | | \\ `-' /| |          \n"
    .ascii "         /_\\           `------'        \\ |   AND        `.\\  | |  `._,' /_\\          \n"
    .ascii "                                        \\|       THE          `.\\                     \n"
    .ascii "                                         ___      _____   _____   ______  ,       _   \n"
    .ascii "                                        |  _ \\   /  _  \\    |       |     |      |__  \n"
    .ascii "                                        | |_| |  | |_| |    |       |     |      |___  \n"
    .ascii "                                        |  _  |  |_____|    |       |     |___           \n"      
    .ascii "                                        | |_| /  |     |    |                             \n"                 
    .ascii "                                        |____/                                             \n\0"                               
ArtTwo:
    .ascii "                      ___________\n"
    .ascii "                 .---'::'        `---.\n"
    .ascii "                (::::::'              )\n"
    .ascii "                |`-----._______.-----'|\n"
    .ascii "                |              :::::::|\n"
    .ascii "               .|               ::::::!-.\n"
    .ascii "               \\|               :::::/|/\n"
    .ascii "                |               ::::::|\n"
    .ascii "                | Freefall Battle  :::|\n"
    .ascii "                |      Winner    :::::|\n"
    .ascii "                |               ::::::|\n"
    .ascii "                |              .::::::|\n"
    .ascii "                J              :::::::F\n"
    .ascii "                 \\            :::::::/\n"
    .ascii "                  `.        .:::::::'\n"
    .ascii "                    `-._  .::::::-'\n"
    .ascii "                        |  \"\"\"|\"\n"
    .ascii "                        |  :::|\n"
    .ascii "                        F   ::J\n"
    .ascii "                       /     ::\\  \n"                                      
    .ascii "                  __.-'      :::`-.__\n"
    .ascii "                 (_           ::::::_)\n"
    .ascii "                   `\"\"\"---------\"\"\"'\n\0"
Health:
    .quad 100

.text
.global _start
_start:

#print the intro
    mov rdx, 7
    call SetForeColor
    lea rdx, Intro
    call PrintZString

    lea rdx, Art
    call LengthZString
    mov rax, rdx

    mov rdi, 0
IntroMessage:
    cmp rdi, rax
    je CreatePlayers

    mov rdx, 7
    call Random
    add rdx, 1
    call SetForeColor

    movb dl, [Art+rdi]
    call PrintChar 

    add rdi, 1
    jmp IntroMessage    

#ask the user how many players
CreatePlayers:

    mov rdx, 7
    call SetForeColor

    lea rdx, PlayerQ
    call PrintZString

    mov rdx, 6
    call SetForeColor
    call ScanInt
    mov Players, rdx
    mov rdx, 7
    call SetForeColor

#creating a loop to create a table for the players health
    mov rdi, 0
    mov rcx, 0

HealthLoop:
    cmp rcx, Players    
    je GameLoop
    
    add rdi, 1    
    lea rax, Health
    movq [rax +rdi *8], 100
    #increment 
    add rcx, 1
    jmp HealthLoop


GameLoop:

    mov rdx, Survivors
    cmp rdx, 1
    je End

    mov rsi, CurrentPlayer

#check if the current player health is 1
    lea rax, Health
    mov rdx, [rax +rsi *8]
    cmp rdx, 1

    #if it is less than one go to next player
    jl DeadPlayer
    jge DisplayStuff

DeadPlayer:

    #if not display that they had died
    lea rdx, Player
    call PrintZString
    mov rdx, rsi
    add rdx, 1
    call PrintInt
    lea rdx, Died
    call PrintZString
    lea rdx, Ghost
    call PrintZString
    jmp Increment

DisplayStuff:
#displaying current player

    mov rdx, 4
    call SetForeColor
    lea rdx, Player
    call PrintZString
    mov rdx, CurrentPlayer
    add rdx, 1
    call PrintInt
    lea rax, PlayerNames
    mov rdi, CurrentPlayer
    mov rdx, [rax +rdi *8]
    call PrintZString
    mov rdx, 7
    call SetForeColor

#displaying health    
    lea rdx, HealthDisplay
    call PrintZString
    lea rax, Health
    mov rdi, CurrentPlayer 
    mov rdx, [rax + rdi *8]
    call PrintInt

    mov rsi, 0
ListAttacks:

    cmp rsi, NumOfAttacks
    je Attacking
    lea rax, Casts
    mov rdx, [rax +rsi *8]
    call PrintZString
    add rsi, 1
    jmp ListAttacks

Attacking:

    lea rdx, AttackQ
    call PrintZString
    call ScanInt
    mov r10, rdx
    mov Choice, rdx
    cmp r10, 1
    je case_one
    cmp r10, 2
    je case_two
    cmp r10, 3
    je case_three
    jmp AttackList

case_one:

    mov rdx, 85
    call Random
    add rdx, 26
    mov Taken, rdx
    
    #roll dice to have the chance for attack to miss
    mov rdx, 100
    call Random
    add rdx, 1
    mov rax, rdx
    #if the chance is greater than 50 then the attack worked
    #if not the attack failed
    cmp rax, 50
    jl AttackFailed
    jmp AttackD

AttackFailed:

    lea rdx, AttackMissed
    call PrintZString
    mov rdx, Taken
    mov rdx, 0
    mov Taken, rdx
    jmp Increment

case_two:

    mov rdx, 30
    call Random
    add rdx, 1
    mov Taken, rdx
    jmp AttackD

case_three:

    mov rdx, 30
    call Random
    add rdx, 1
    mov Chance, rdx
    #heal current player
    lea rax, Health
    mov rsi, CurrentPlayer
    mov rdx, [rax + rsi *8]
    add rdx, Chance
    mov [rax + rsi *8], rdx
    jmp AttackD

#target
AttackD:
    lea rdx, AttackList
    call PrintZString

    mov rdi, 0
#for each player whos health is more than 1 display it
For:

    lea rax, Health
    mov rdx, [rax +rdi *8]
    cmp rdx, 1
    jge ListPlayer
    add rdi, 1
    
ListPlayer:

    lea rdx, Player
    call PrintZString
    mov rdx, rdi
    add rdx, 1
    call PrintInt
    #incrementing
    add rdi, 1
    #if rdi = survivors ask user which target
    cmp rdi, Players
    je TargetQ
    jl For    

TargetQ:

    lea rdx, TargetDisplay
    call PrintZString
    mov rdx, 6
    call SetForeColor
    call ScanInt
    #check if user enter a valid target if not ask the question again
    cmp rdx, Players
    jg TargetQ  
    sub rdx, 1
    mov Target, rdx
    mov rdx, 7
    call SetForeColor
 
#displaying attack damage
Attacks:

    mov rbx, Choice
    cmp rbx, 3
    je Heal

    lea rdx, Damage
    call PrintZString
    mov rdx, 1
    call SetForeColor
    mov rdx, Taken
    call PrintInt
    mov rdx, 7
    call SetForeColor
    lea rdx, Damage2
    call PrintZString

    #subtract the health from target
    lea rax, Health
    mov rdi, Target
    mov rdx, [rax + rdi *8]     
    sub rdx, Taken
    mov [rax + rdi *8], rdx
    jmp Increment

Heal:

    lea rdx, Healed
    call PrintZString
    mov rdx, Chance
    call PrintInt
    lea rax, Health
    mov rdi, Target
    mov rdx, [rax +rdi *8]
    add rdx, Chance
    mov [rax +rdi*8], rdx
    jmp Increment

#increment to the next player
Increment:

     mov r8, CurrentPlayer
     add r8, 1
     cmp r8, Players
     je Reset

#if not continue to next player
     mov CurrentPlayer, r8
     mov rdi, Survivors

#count surviving players
Surviving:
     
    cmp rdi, Players
    je GameLoop

    lea rax, Health
    mov rdx, [rax +rdi *8]  
    cmp rdx, 1
    jge Plus
     
    add rdi, 1
    jmp Surviving
    

Plus:
     mov rbx, Survivors
     add rbx, 1
     mov Survivors, rbx
     add rdi, 1
     jmp Surviving

Reset:
    mov rdx, Survivors
    cmp rdx, 1
    je End
    movq Survivors, 0
    movq CurrentPlayer, 0
    jmp GameLoop

End:
    mov rdi, 0
    lea rax, Health

RealEnd:
    mov rdx, [rax +rdi *8]
    add rdi, 1
    mov Winner, rdi
    cmp rdx, 1
    jge DisplayWinner
    jmp RealEnd

DisplayWinner:

#dispaly the winner and the trophy in yellow

    mov rdx, 3
    call SetForeColor
    lea rdx, ArtTwo
    call PrintZString

    mov rdx, 7
    call SetForeColor

    lea rdx, LastPlayer
    call PrintZString

    lea rax, PlayerNames
    mov rdi, Winner
    sub rdi, 1
    mov rdx, [rax +rdi *8]
    call PrintZString
    
    call Exit

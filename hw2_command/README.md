# Sample Table using Command Pattern

## Expanded Use case
UC1: Adding a row in table

| Actor: User  | System: TableEditor |
| --- | --- |
| | 0. System displays empty table with add, delete, undo and delete buttons. |
| 1. **TUCBW** User clicks on Add Button | 2. System displays the dialog box, asking user to enter item ID and content |
| 3. The User(a) enters id and content and clicks OK button.(b) clicks cancel button to abort | 4. The System <br/>(a) add the row in table. <br/>(b) discard the user input |
| 5. **TUCEW** The user sees the row added in table or discarded. | |

UC2: Deleting a row in table

| Precondition: The Table should not be empty |
| --- |

| Actor: User | System: TableEditor |
| --- | --- |
|     | 0. System displays table with add, delete, undo and delete buttons |
| 1. **TUCBW** User select a row and click delete | 2. System deletes the selected row. |
| 3. **TUCEW** User sees the updated table | |

| Postcondition: NONE |
| --- |

UC3: Undo Operation

| Actor: User | System: TableEditor |
| --- | --- |
|     | 0. System displays table with add, delete, undo and delete buttons |
| 1. **TUCBW** User click on undo button | 2. System removes the last executed command |
| 3. **TUCEW** User sees the updated table | |

UC4: Redo Operation

| Actor: User | System: TableEditor |
| --- | --- |
|      | 0. System displays table with add, delete, undo and delete buttons |
| 1. **TUCBW** User click on redo button | 2. System restore the last executed command |
| 3. **TUCEW** User sees the updated table | |




**Non-Trivial Steps:**

UC1: Step 4. System add the row in table

3. User enters id and content

4.1 if user button on Dialog box

4.2 Dialog box sends click event to TableGUIController

4.3 If button clicked in OK

4.3.1 TableGUIController creates command object for adding row passing the entered value.

4.3.2 TableGUIController set up the command by calling ExecuteCommand.

4.3.3 TableGUIController clears the redo stack

4.3.4 TableGUIController push the new command in undo stack

4.3.5 command add a row in table.

4.4 else if button clicked cancel

4.4.1 return

4.5 TableGUI displays updated table to user

**Scenario Table**

| # | Subject | Action | Object | Other Data |
| --- | --- | --- | --- | --- |
| 4.1 | User | Click | Dialog Box | Event data |
| 4.2 | Dialog box | Send | TableGUIController | Event data |
| 4.3 | If OK Clicked | | | |
| 4.3.1 | TableGUIController | Creates | Command | Dialog box data, Table |
| 4.3.2 | TableGUIController | Sets up | TableGUIController | Command |
| 4.3.3 | TableGUIController | Clears | Redo stack | Command |
| 4.3.4 | TableGUIController | Push | Undo Stack | Command |
| 4.3.5 | Command | Execute | Table | Dialog box data |
| 4.4 | Else cancel clicked | | | |
| 4.4.1 | TableGUIController | Return | TableGUI | |
| 4.5 | TableGUI | Displays | User | Table |

UC2: Step 2. System deletes the selected row

1. User select a row in table and click delete

2.1 TableGUI sends click event to TableGUIController with event data.

2.2 TableGUIController create a command object using table data

2.2.1 TableGUIController set up the command by calling ExecuteCommand.

2.2.2 TableGUIController clears the redo stack

2.2.3 TableGUIController push the new command in undo stack

2.3 command deletes a row in Table.

2.4 TableGUI displays updated table to user

| # | Subject | Action | Object | Other Data |
| --- | --- | --- | --- | --- |
| 1 | User | Select and click delete | TableGUI | Event Data |
| 2.1 | TableGUI | Sends | TableGUIController | Event Data |
| 2.2 | TableGUIController | Creates | Command | Table |
| 2.2.1 | TableGUIController | Sets Up | TableGUIController | Command |
| 2.2.2 | TableGUIController | Clears | Redo Stack |
 |
| 2.2.3 | TableGUIController | Push | Undo Stack | Command |
| 2.3 | Command | Delete | Table | TableGUI |
| 2.4 | TableGUI | Display | User | Table |

UC3: Step 2. System removes the last executed command

1. User clicks on undo button

2.1 TableGUI sends click event to TableGUIController with event data.

2.1.1 TableGUIController pop 1 command from undo stack

2.1.2 TableGUIController push the popped command in redo stack

2.2 TableGUIController calls undo on command.

2.3 command undo the last operation on TableGUI

2.4 TableGUI displays updated table to user.

| # | Subject | Action | Object | Other Data |
| --- | --- | --- | --- | --- |
| 1 | User | Click | TableGUI | Button |
| 2.1 | TableGUI | Sends | TableGUIController | Event data |
| 2.1.1 | TableGUIController | Pop | Undo stack | Command |
| 2.1.2 | TableGUIController | Push | Redo Stack | Command |
| 2.2 | TableGUIController | Undo | Command | |
| 2.3 | Command | Undo | TableGUI | Table |
| 2.4 | TableGUI | Displays | User | Table |

UC4: Step2. System removes the last executed command

1. User clicks on redo button

2.1 TableGUI sends click event to TableGUIController with event data.

2.1.1 TableGUIController pop 1 command from redo stack

2.1.2 TableGUIController push the popped command in undo stack

2.2 TableGUIController calls redo on command.

2.3 command redo the last operation on TableGUI

2.4 TableGUI displays updated table to user.

| # | Subject | Action | Object | Other Data |
| --- | --- | --- | --- | --- |
| 1 | User | Click | TableGUI | Button |
| 2.1 | TableGUI | Sends | TableGUIController | Event data |
| 2.1.1 | TableGUIController | Pop | Redo stack | Command |
| 2.1.2 | TableGUIController | Push | Undo Stack | Command |
| 2.2 | TableGUIController | Redo | Command | |
| 2.3 | Command | Redo | TableGUI | Table |
| 2.4 | TableGUI | Displays | User | Table |



## Informal Sequence Diagram

![formal_sequence](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/316037d1-3026-41a2-9118-e7bca45655a5)

## Sequence Diagram
![Informal_Sequence_2](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/f134496e-9587-497e-8212-643ae537e647)

## Class Diagram
![Class_Diagram](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/0ba1e132-9665-4aca-88b3-afda110bda47)

## Demo
https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/a65cab50-25df-47c3-a1d8-0c799e404dbd




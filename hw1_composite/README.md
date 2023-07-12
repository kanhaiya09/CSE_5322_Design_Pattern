# HW1_Composite

### Domain Model Class Diagram (DCMD)
![Domain_Model_Diagram](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/a4504b12-65dc-4e74-88f8-615254bae6fd)


### Expanded Use Case
| Actor : User | System : Paint |
|------------- |----------------|
| 0. System displays 3 buttons and canvas drawing area. ||
| 1. **TUCBW** User clicks on 1 of the 3 Shape buttons.    | 2. System knows the shape to draw. |
| 3. User clicks on the canvas drawing area.           | 4. System paints the shape at the position clicked. |
| 5. **TUCEW** User sees the desired shape                 |


### Non Trivial Steps

Step 2. System knows the shape to draw

Step 4. System paints the shape at the position clicked.

**Step2 :**

1. User clicks on the shape button

2.1 The Shape button sends a click event to GUIController with even data.

2.2 the GUIController changes the current shape using event data

2.3 GUIController knows the shape to draw

**Step 4 :**

3. User clicks on canvas drawing area

4.1 The PaintGUI send click event to PaintGUIController with event data

4.2 PaintGUIController gets the location of mouse click from event data

4.2.1 PaintGUIController create the current shape with location

4.2.2 GUIController add the created shape to CompositeShape collection

4.3 CompositeShape uses IteratorPattern and calls draw on each shape using graphic context object

4.4 Graphic context object draw on PaintGUI

4.5 PaintGUI displays shape to user.

### Scenario Table
1. System knows the shape to draw

| **#** | **Subject** | **Action** | **Object** | **Other Data** |
| --- | --- | --- | --- | --- |
| 1 | User | Click | PaintGUI | Button |
| 2.1 | PaintGUI | Send | PaintGUIController | Event data |
| 2.2 | PaintGUIController | Changes ShapeType | PaintGUIController | Event Data |

2. System paints the shape at the position clicked

| **#** | **Subject** | **Action** | **Object** | **Other Data** |
| --- | --- | --- | --- | --- |
| 3 | User | Click on | PaintGUI | CanvasPanel |
| 4.1 | PaintGUI | Send | PaintGUIController | Event data |
| 4.2 | PaintGUIController | Gets location | PaintGUIController | Event data |
| 4.2.1 | PaintGUIController | Creates | Shape | ShapeType |
| 4.2.2 | Shape | Returns | PaintGUIController | Shape object |
| 4.2.3 | PaintGUIController | Add | CompositeShape | Shape |
| 4.3 | CompositeShape | Draw | Shape | ShapeCollection |
| 4.4 | Shape | Draw | Graphics | Location |
| 4.5 | Graphics | Draw | PaintGUI | Shape |
| 4.6 | PaintGUI | Displays | Shape | User |


### Informal Sequence Diagram
![Infromal_Sequence_Diagram](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/11c39486-83bd-4ad1-8918-88f0b199a9da)


### Formal Sequence Diagram
![Formal_Sequence_Diagram](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/98633761-8573-4478-a4e0-d97936710538)

### Design Class Diagram
![Design_Class_Diagram](https://github.com/kanhaiya09/CSE_5322_Design_Pattern/assets/34772291/4fa613ef-f0c4-4988-b4eb-17a2b5d80d84)



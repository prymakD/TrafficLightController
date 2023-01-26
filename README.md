# Trafficlight controller

There's a road intersection - a regular one, just two perpendicular roads. There're traffic lights installed but the standard algorithm is quite inefficient. Luckily recently some inductive loops have been installed. After analyzing measurements of road traffic parameters someone came up with a set of priority rules for a better traffic light controller. 

1.  Vehicles on road A should be allowed to pass the intersection without stopping if there's not other traffic.
2.  If at the end of the first cycle there are still some vehicles on road A let's allow them to pass the intersection without stopping for yet another cycle.
3.  At the end of the second cycle of vehicles on road A passing the intersection, there're some vehicles on road B waiting - let's grant them (vehicles on road B) one cycle of passage.
4.  If there aren't any vehicles on road A waiting while the first cycle for road B ends then grant yet another cycle for road B.

Our goal is to develop a driver for the traffic light that analyses the incoming signals from the inductive loops, respects the above priorities and switches particular lights in the desired manner.

 details

1\. Report:

* how to run the code?

* what was to be difficult to accomplish?

* where did you fail?

* what makes your solution special? what deserves appreciation?

2\. Code

3\. Some recording or screenshots demonstrating that it actually works (correctly).

General remarks

A basic traffic light cycles is: red (no go), red&yellow (ready), green (go), yellow (stop).

The controller is not driven by inductive loops signals. What drives the controller is the clock used to measure the light cycle intervals. The ticking of the clock is the primary (implicit) input whereas the signals from inductive loops (about awaiting or passing by vehicles) form the secondary (explicite) input to the controller.

The controller outputs signals (R,RY,G,Y) for two pairs of traffic light.

The controller may only use signals from inductive loop for situational awareness. There aren't any traffic cameras that could be used to count awaiting or approaching vehicles.

The controller is not concerned by pedestrians or turning vehicles.

The logic of the controller ignores in which way the vehicles are moving on a particular road. Two inductive loops mounted on the same road logically constitute a single sensor.

The road intersection works just like a charm - there are not traffic jams, the traffic is not obstructed in any way. If a vehicle is detected by the inductive loop while the green light is on, it's guarantied to enter and exit the intersection. A vehicle detected by the inductive loop while the red or yellow light is one is guarantied not to enter the intersection.

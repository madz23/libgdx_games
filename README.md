# simpleGame

3/30
This is the game from the libGDX tutorial at https://libgdx.com/wiki/start/a-simple-game.

# zombie

3/30
A simple animation using the sprite sheet and tutorial at https://libgdx.com/wiki/graphics/2d/2d-animation.

3/31
This file was called runningMan, but has since been changed to use a zombie sprite I found at https://www.gameart2d.com/freebies.html, since most free sprites are not organized in a sprite sheet but in separate images. In any case, I can use both now.

# soundBoard

3/31
I like finding free sounds online, and I needed to learn more about widgets so I built this very ugly sound board. I need to work on skins and tables, but it was fun.

All the sounds come from https://freesound.org.

* Game - Style Shot (Noise) by Jofae
* Robotness by thehorriblejoke
* jump2.wav by LloydEvans09
* Little, happy tune - 22.10.2015 by cabled_mess
* Break Loop | tictac9 by tictac9
* Frog.ogg by egomassive

# moo

4/2
This is the only "game" worthy of note and the only project here that will likely evolve into a more developed and likely playable game. The animation for the cow was all done by me, but the libGDX skin and sounds are currently being pulled from free websites. More information to come as I actually work on this. As of now, the there is a main menu screen with a play button which takes you to the cow screen where you can control the cow with the arrow keys.

4/3
Moo has made a decent amount of progress. The cow can move around the whole screen and moo. There is background music. The cow can moo, though it is super weird sounding. I need to fix that. Next, I will implement tiles.

4/25
I found some time to work on this project last week. There is a full tile map that the cow can walk on. It extends beyond the view of the screen, and the camera can follow the cow wherever she walks on the map. The screen is 100x100, and the map is 800x800. I need to make it so that the screen can be resized. The cow has an eat animation and can only eat when standing on a grassy tile. Eating fills the cow's tummies (hearts basically). 

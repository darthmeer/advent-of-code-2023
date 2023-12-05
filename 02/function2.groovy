#!/usr/bin/groovy

def totalBallsList = []
def handfuls, ballTotals, colourTotals, gameId, ballPower
def colours = [ "red", "green", "blue" ]

new File('input.txt').eachLine { game ->

  gameId = game.split(':').first().replace('Game ','')
  handfuls = game.split(':').last().split(';')
  ballTotals = []

  colours.each { colour ->
    colourTotals = []
    handfuls.each { handful ->
      handful.split(',').each { balls ->
        if (balls.contains(colour)) {
          colourTotals.add(balls.findAll(/\d+/)*.toInteger()[0])
        }
      }
    }
    ballTotals.add(colourTotals.sort().last())
  }
  ballPower = ballTotals[0] * ballTotals[1] * ballTotals[2] 
  println("game " + gameId + ": " + ballTotals + ": " + ballPower)
  totalBallsList.add(ballPower)

}

// dedupe values and print result
println(totalBallsList.sum())

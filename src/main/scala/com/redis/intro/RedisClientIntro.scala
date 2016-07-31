package com.redis.intro

import com.redis.RedisClient

/**
  * Created by raitis on 30/07/2016.
  */

object RedisClientIntro extends App {

  val r = new RedisClient("localhost", 6379)
  r.flushdb // delete all

  // LISTS

  r.set("key", "some value")
  val res1 = r.get("key")
  println(res1)

  // list operations
  r.lpush("list-1", "foo")
  println(r.lrange("list-1", 0, -1))

  r.rpush("list-1", "bar")
  println(r.lrange("list-1", 0, -1))

  println(r.llen("list-1"))

  // HASH

  r.hmset("hash", Map("field1" -> "1", "field2" -> 2))
  println(r.hgetall("hash"))
  println(r.hget("hash", "field1"))
  // or
  println(r.hmget[String,String]("hash", "field1", "field2"))

}

// SET UP
//
// install:
//   brew install redis
// run server:
//   redis-server /usr/local/etc/redis.conf
// redis.conf:
//   change port, bind host,

// run client:
//   redis-cli

// run monitor:
// redis-cli monitor

// DB
//
// change db:
//   select 1
//   select 2
//   etc

// After restart data is saved.
// To delete data:
//   flushdb
//   flushall (for multiple db)

// STRING AND KEYS
//
// set name Ray
// set hobby "computers reading"
// get name
// get hobby
// mset mamal whale insect "June Bug" (mset key name key name key name etc)
// get mamal
// get insect

// keys name
// keys * or keys nam*
// exists dog
// del name - return 1 or 0
// rename name myname - rename key
// setnx or renamenx - do if exist

// pexpire name - expire in 5s
// persist name - check if it still exist (0 or 1)
// ttl name - time to live (sec or -1)

// strlen name

// INT
// set age 20
// incr age
// incrby age 5
// decr age

// HASH
//
// hset people Jan 12
// hset people Ray 32
// hget people Ray
// hgetall people
// hmset people kim 9 sue 12
// hdel people Ray Jan
// hlen people - how many

// hmset scores u1 0 u2 0 u3 0
// hincrby scores u1 2
// hexists scores u6 - exists (0 or 1)
// hkeys scores
// hvals scores

// LISTS
//
// lpush colors red green blue - new list with elements
// llen colors - length
// lrange colors 0 -1 - all list
// lrange colors 0 2 - segment
// lset colors 0 newcolor - for existing list value change it
// linsert colors after blue purple
// lpop colors - remove first
// rpop colors - remove last

// lpushx animals pig -push only if list exist
// lrem colors 2 red - amount of values to remove (front to backwards)
// lrem colors -2 red - amount of values to remove (back to forwards)
// lrem colors 0 red - remove all red
// rpush colors yellow - push to right

// cannot create list within the list!

// SETS
//
// sadd art pencill paint brush canvas - create set with elements (return int elements)
// scard art - count elements
// srem art pencil - remove element (0 or 1)
// sadd art pencil - add (0 if already exist or 1)
// smembers art - all members
// sismember art pencil - is member
// sunion art art2 - join unique elements
// sdiff art art2 - unique art elements which are not in art2
// sinter art art2 - common element
// sunionstore x art art2 - save union as x
// sdiffstore..
// sinterstore..

// SORTED SETS (player scores in the game etc.)
//
// zadd players 10 ben 20 kim 40 tammy - z -> sorted
// zadd players 15 tiger
// zrange players 0 -1
// zrange players 0 -1 withscores - keys and values
// zrevrange players 0 -1
// zrevrange players 0 0 - last one
// zscore players kim
// zcard players - how many players
// zcount players 0 20 - count players with score 0 - 20
// zrangebyscore players 0 30 - player names with score 0 - 30

// HYPERLOGLOG
//
// for big datasets instead of use sets and sadd:
// pfadd .. then merge and count per period..

// PUBSUB
//
// subscribe general - clients (also as a redis-cli)
// subscribe farmers
// publish general "How are you?" - broadcaster
// pubsub channels * - list subscribers (from broadcaster)

// psubscribe pr* - client subscribe to any chanel started with pr
// publish problem problem1 - from broadcaster
// psubscribe h[ea]llo
// publish hello man - ok
// publish hallo man - ok
// publish hllo man - not ok

// TRANSACTIONS
//
// MULTI - to start
// set day bright (qued)
// EXEC - executed (executed)
// DISCARD - cancel transaction

// COMMANDS
//
// echo hallo - echo something
// ping - ping redis
// set - set name
// select 0 - delect db
// quit - quit redis
// auth - in config file set -> requirepass password and restart redis server
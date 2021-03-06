//
// Copyright  2015  Comcast Cable Communications Management, LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
import sbt._
import Keys._

organization := "com.comcast"

name := "actor-service-registry-aggregate"

version := "1.0-SNAPSHOT"

scalaVersion := "2.11.6"

test in publish := {}


lazy val common = Project(id = "common",
                            base = file("common"))

lazy val serviceRegistry = Project(id = "serviceRegistry",
                            base = file("serviceRegistry"))
                            .dependsOn(common)

lazy val root = Project(id = "root",
                            base = file("."))
                            .aggregate(common, serviceRegistry)



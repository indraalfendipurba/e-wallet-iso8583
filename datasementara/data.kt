package com.example.e_wallet12021996ver1.datasementara

//data LayarSendFund

/*
      if (data2 == 1) {
          jalan1()
      } else if (data2 == 2) {
          jalan2()
      } else if (data2 == 3) {
          jalan3()
      } else if (data2 == 4) {
          jalan4()
      } else if (data2 == 5) {
          jalan5()
      } else if (data2 == 6) {
          jalan6()
      } else if (data2 == 7) {
          jalan7()
      } else if (data2 == 8) {
          jalan8()
      } else {
          jalan9()
      }
      }
  }

  private fun jalan1(){
      val jalan = etkirim.length()
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "0000000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      val kirim = "kirim"

      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })

      db.inserData1( kirim, jalan1_1.trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()

  }

  private fun jalan2(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "0000000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan3(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "000000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan4(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "00000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan5(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "0000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan6(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "000${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan7(){
      val jalan1_1 = etkirim.text.toString().trim()
      val jalan1_2 = "${jalan1_1}"
      val dataiso  = "${iso}${jalan1_2}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan8(){
      val jalan1_1 = etkirim.text.toString().trim()
      val dataiso  = "${iso}${jalan1_1}"
      val date_1 = SimpleDateFormat("dd/MM/yyyy")
      val date_2 = date_1.format(Date())
      val time_1 = SimpleDateFormat("hh:mm:ss")
      val time_2 = time_1.format(Date())
      var kirim = "kirim"
      ref.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                  refa.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
      db.inserData1( kirim.toString().trim(), jalan1_1.toString().trim(), date_2.toString().trim(), time_2.toString().trim())
      Toast.makeText(this, "terkirim", Toast.LENGTH_LONG).show()
      hasilanak()
  }

  private fun jalan9(){
      etkirim.error = "Tolong isi nominal yang benar"

  }//*/

  private fun hasilanak(){
      refb.addListenerForSingleValueEvent(object : ValueEventListener {

          override fun onDataChange(p0: DataSnapshot)  {
              var list1 = mutableListOf<String>()
              var it : Iterable<DataSnapshot> = p0!!.children

              it.forEach{
                  var msg = ""
                  var itr = it.children
                  itr.forEach{
                      msg = msg+"\n"+it.value
                  }
                  //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)

                  refc.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object : ValueEventListener {

                      override fun onDataChange(p0: DataSnapshot)  {
                          var list1 = mutableListOf<String>()
                          var it : Iterable<DataSnapshot> = p0!!.children

                          it.forEach{
                              var msg = ""
                              var itr = it.children
                              itr.forEach{
                                  msg = msg+"\n"+it.value
                              }
                              //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue(dataiso)
                              val msg1 = msg.toString().toInt()
                              val hasil = msg1 + nominal
                              refc.child(msg.trim()).child("saldo").child("push").child("nilai").setValue(hasil)

                          }
                      }
                      override fun onCancelled(p0: DatabaseError) {
                          TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                      }
                  })
              }
          }
          override fun onCancelled(p0: DatabaseError) {
              TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
          }
      })
  }
}
*/

        /*
            fun jalan2(data: model2){

        val psn = data.dana
        refb.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot)  {

                var it : Iterable<DataSnapshot> = p0!!.children

                it.forEach{
                    var msg = ""
                    var itr = it.children
                    itr.forEach{
                        msg = msg+"\n"+it.value
                    }

                    //refa.child(msg.trim()).child("database1").child("push").child("iso").setValue()
                    refc.child(msg.trim()).child("saldo").addListenerForSingleValueEvent(object :
                        ValueEventListener {

                        override fun onDataChange(p0: DataSnapshot)  {
                            var list1 = mutableListOf<String>()
                            var it : Iterable<DataSnapshot> = p0!!.children

                            it.forEach{
                                var msg = ""
                                var itr = it.children
                                itr.forEach{
                                    msg = msg+"\n"+it.value
                                }

                                val panjang = psn.length
                                val date_1 = SimpleDateFormat("ddMMyyyy")
                                val date_2 = date_1.format(Date())
                                val time_1 = SimpleDateFormat("hhmmss")
                                val time_2 = time_1.format(Date())
                                val dataiso = "1210201A001000000000000010${time_2}${date_2}"
                                if (panjang == 1) {

                                    val data = "${dataiso}0000000${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)

                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }
                                else if (panjang == 2) {

                                    val data = "${dataiso}000000${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)

                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })

                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }
                                else if (panjang == 3) {

                                    val data = "${dataiso}00000${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }
                                else if (panjang == 4) {

                                    val data = "${dataiso}0000${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)

                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }
                                else if (panjang == 5) {

                                    val data = "${dataiso}000${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })

                                }
                                else if (panjang == 6) {

                                    val data = "${dataiso}00${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)
                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })

                                }
                                else if (panjang == 7) {

                                    val data = "${dataiso}0${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)

                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })

                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }
                                else if (panjang == 8) {

                                    val data = "${dataiso}${psn}"
                                    ref.addListenerForSingleValueEvent(object : ValueEventListener {

                                        override fun onDataChange(p0: DataSnapshot)  {
                                            var list1 = mutableListOf<String>()
                                            var it : Iterable<DataSnapshot> = p0!!.children

                                            it.forEach{
                                                var msg = ""
                                                var itr = it.children
                                                itr.forEach{
                                                    msg = msg+"\n"+it.value
                                                }
                                                refa.child(msg.trim()).child("database1").push().child("iso").setValue(data)

                                            }
                                        }
                                        override fun onCancelled(p0: DatabaseError) {
                                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                        }
                                    })
                                    Toast.makeText(mCtx, "permintaan ditolak", Toast.LENGTH_LONG).show()
                                }

                            }

                        }

                        override fun onCancelled(p0: DatabaseError) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }


                    })

                }
            }
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }
         */